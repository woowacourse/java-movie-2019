import domain.*;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

public class MovieApplication {
    ReservationStorage reservationStorage = new ReservationStorage();

    public void showAllMovieInfo() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public void reserveMovie() {
        Movie movieToReserve = selectMovieToReserve();
        PlaySchedule playSchedule = selectPlayScheduleToReserve(movieToReserve);
        int peopleToReserve = selectPeopleToReserve(playSchedule);
        reservationStorage.addReservation(new ReservedMovie(movieToReserve, playSchedule, peopleToReserve));
        selectToGoToPaymentStep();
    }

    private Movie selectMovieToReserve() {
        int movieId = InputView.inputMovieId();
        Movie movieToReserve = MovieRepository.getMovieById(movieId);
        OutputView.printMovie(movieToReserve);
        return movieToReserve;
    }

    private PlaySchedule selectPlayScheduleToReserve(Movie movie) {
        return InputView.inputPlaySchedule(movie);
    }

    private int selectPeopleToReserve(PlaySchedule playSchedule) {
        return InputView.inputPeopleToReserve(playSchedule);
    }

    private void selectToGoToPaymentStep() {
        int selection = InputView.inputPaymentDecision();
        if (selection == InputView.FIRST_SELECTION) {
            OutputView.printAllReservedMovies(reservationStorage);
        }
        if (selection == InputView.SECOND_SELECTION) {
            reserveMovie();
        }
    }

    private void progressPayment() {
        InputView.guideForPayment();
        MoviePoint moviePoint = InputView.inputMoviePoint();
        int selection = selectPaymentMethod();
        if (selection == InputView.FIRST_SELECTION) {
            // 신용카드로 결제 처리
        }
        if (selection == InputView.SECOND_SELECTION) {
            // 현금으로 결제 처리
        }
    }

    private int selectPaymentMethod() {
        return InputView.inputPaymentMethodDecision();
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.showAllMovieInfo();
        movieApplication.reserveMovie();
        movieApplication.progressPayment();
    }
}
