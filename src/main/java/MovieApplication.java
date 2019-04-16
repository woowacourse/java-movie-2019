import domain.Movie;
import domain.MovieRepository;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {

    private static final int RESERVATION_FINISHED = 1;
    private static final int ADDITIONAL_RESERVATION = 2;
    private static final int MIN = 0;
    private static final int CONSTANT_TO_MAKE_INDEX = 1;

    public void printSelectedMovieInfo(int movieId, List<Movie> movies) {
        for (Movie movie : movies) {
            printSelectedMovieInformation(movie, movieId);
        }
    }

    public void printSelectedMovieInformation(Movie movie, int movieId) {
        if (movie.checkMovieId(movieId)) {
            System.out.println(movie);
        }
    }

    public Movie movieSelection(int movieId, List<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.checkMovieId(movieId)) {
                return movie;
            }
        }
        return null;
    }

    public int timeTableSelectionInput(Movie reservingMovie) {
        try {
            int selectedTimeTable = InputView.inputTimeTable();
            checkIfselectedTableInTimeTable(selectedTimeTable, reservingMovie);
            return selectedTimeTable;
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return timeTableSelectionInput(reservingMovie);
        }
    }

    public void checkIfselectedTableInTimeTable(int selectedTable, Movie reservingMovie) {
        if (selectedTable <= MIN || selectedTable > reservingMovie.getPlayScehdules().size()) {
            throw new IllegalArgumentException("존재 하지 않는 상영시간(시간표) 입니다. 다시 입력해주세요.");
        }
    }

    public int reservingNumberInput(Movie reservingMovie, int selectedTable) {
        try {
            int reservationNumber = InputView.inputReservationNumber();
            checkIfreservationNumberIsAvailable(reservationNumber, reservingMovie, selectedTable);
            return reservationNumber;
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return reservingNumberInput(reservingMovie, selectedTable);
        }
    }

    public void checkIfreservationNumberIsAvailable(int reservationNumber, Movie reservingMovie, int selectedTable) {
        if (reservationNumber == MIN || reservingMovie.getPlayScehdules().get(selectedTable).getCapacity() < reservationNumber) {
            throw new IllegalArgumentException("예약 인원을 입력하지 않았거나 예약 가능 인원을 초과하였습니다. 다시 입력해 주세요.");
        }
    }

    public int payOrAdditionalReservationInput() {
        try {
            int payOrReservation = InputView.inputPayOrAdditionalReservation();
            checkIfPayOrReservationIsProper(payOrReservation);
            return payOrReservation;

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return payOrAdditionalReservationInput();
        }
    }

    public void checkIfPayOrReservationIsProper(int payOrReservation) {
        if (payOrReservation < RESERVATION_FINISHED || payOrReservation > ADDITIONAL_RESERVATION) {
            throw new IllegalArgumentException("1 또는 2의 숫자를 입력해주세요.");
        }
    }

    public boolean checkIfReservationEnd(int payOrAdditionalReservation) {
        if (payOrAdditionalReservation == ADDITIONAL_RESERVATION) {
            //TODO : 위로 돌아감
            return false;
        }
        return true;
    }

    public void printReservationList(List<Movie> reservedMovie, int selectedTable, int reservationNumber) {


    }

    public boolean checkIfOneHourWithinRange(List<Movie> reservedMovie, LocalDateTime dateTimetoCheck, int selectedTable) {
        boolean isOneHourWithinRange = false;
        for (Movie movie : reservedMovie){
            LocalDateTime movieTimeToCheck = movie.getPlayScehdules().get(selectedTable).getStartDateTime();
            DateTimeUtils.isOneHourWithinRange(movieTimeToCheck, dateTimetoCheck);
        }
        return isOneHourWithinRange;

    }


    public void getStartingHours

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        MovieApplication m = new MovieApplication();
        List<Movie> reservedMovie = new ArrayList<>();

        boolean isReservationEnd = false;
        boolean isOneHourWithinRange = false;
        //TODO : 바깥 루프 필요함
        while (!isReservationEnd) {
            int movieId = InputView.inputMovieId();
            m.printSelectedMovieInfo(movieId, movies);
            Movie movieReservingNow = m.movieSelection(movieId, movies);
            reservedMovie.add(m.movieSelection(movieId, movies));
            int selectedTable = m.timeTableSelectionInput(movieReservingNow);

            LocalDateTime dateTimeToCheck = movieReservingNow.getPlayScehdules().get(selectedTable).getStartDateTime();
            isOneHourWithinRange = m.checkIfOneHourWithinRange(reservedMovie, dateTimeToCheck, selectedTable);
            if (isOneHourWithinRange) {
                System.out.println("상영 시간이 예매된 영화와 1시간 이내입니다. 다시 예약 해주세요.");
                continue;
            }
            int reseravationNumber = m.reservingNumberInput(movieReservingNow, selectedTable);


            int payOrAdditionalReservation = m.payOrAdditionalReservationInput();
            isReservationEnd = m.checkIfReservationEnd(payOrAdditionalReservation);
        }
        //예약이 끝낫다면,
        printReservationList(reservedMovie);
        InputView.printPaymentRunningMessage();
        int amountOfPointToUse = InputView.inputAmountOfPointToUse();
        int payByCreditOrCash = InputView.inputPayByCreditCardOrCash();

        //예약 내역 프린트. 이건 movie 정보를 받아야겟지


    }
    // TODO 구현 진행

}

