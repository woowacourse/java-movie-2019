package domain;

import view.InputView;
import view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class MovieReservation {
    private static final int END = 1;
    private static final int CONTINUE = 2;

    private List<Reservation> reservationList;

    public MovieReservation() {
        reservationList = new LinkedList<>();
    }

    public void reservationMovie() {
        try {
            OutputView.printMovies(MovieRepository.getMovies());
            Movie selectedMovie = selectMovie();
            selectScheduleAndPerson(selectedMovie);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            reservationMovie();
        }
    }

    public int totalPrice() {
        int total = 0;
        for (Reservation reservation : reservationList) {
            total += reservation.calculatePrice();
        }
        return total;
    }

    private Movie selectMovie() {
        int movieID = InputView.inputMovieId();
        Movie selectedMovie = MovieRepository.getMovieSchedule(movieID);
        OutputView.printMovie(selectedMovie);
        return selectedMovie;
    }

    private void selectScheduleAndPerson(Movie selectedMovie) {
        int scheduleNumber = InputView.inputTimeSchedule() - 1;
        if (selectedMovie.cantSchedule(scheduleNumber)) {
            throw new IllegalArgumentException("예매할 수 없는 시간대입니다.");
        }
        int numberOfPerson = InputView.inputPerson();
        validProcess(selectedMovie, scheduleNumber, numberOfPerson);
        reservationProcess(selectedMovie, scheduleNumber, numberOfPerson);
        continueReservation();
    }

    private void validProcess(Movie selectedMovie, int scheduleNumber, int numberOfPerson) {
        if (numberOfPerson < 0) {
            throw new IllegalArgumentException("사람 수는 0명 이하가 될 수 없습니다.");
        }
        if (selectedMovie.overPersonReservation(scheduleNumber, numberOfPerson)) {
            throw new IllegalArgumentException("해당 시간의 예매 가능 인원이 초과되었습니다.");
        }
        if (notValidReservationTime(selectedMovie, scheduleNumber)) {
            throw new IllegalArgumentException("예매 내역 중에 1시간 이내로 겹치는 영화가 있습니다.");
        }
    }

    private boolean notValidReservationTime(Movie selectedMovie, int scheduleNumber) {
        boolean valid = true;
        for (Reservation reservation : reservationList) {
            valid &= reservation.isValidBetweenThisMovie(selectedMovie, scheduleNumber);
        }
        return !valid;
    }

    private void reservationProcess(Movie selectedMovie, int scheduleNumber, int numberOfPerson) {
        reservationList.add(selectedMovie.reservation(scheduleNumber, numberOfPerson));
    }

    private void continueReservation() {
        int reservationEnd = InputView.inputReservationEnd();
        if (reservationEnd != CONTINUE && reservationEnd != END) {
            OutputView.printError("반드시 1 또는 2로 입력해주세요!");
            continueReservation();
        }
        if (reservationEnd == CONTINUE) {
            reservationMovie();
        }
    }
}
