import domain.Movie;
import domain.MovieRepository;
import domain.ReservedMovie;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.*;

public class MovieApplication {

    private static final int RESERVATION_FINISHED = 1;
    private static final int ADDITIONAL_RESERVATION = 2;
    private static final int TO_SCREEN_NULL = 0;
    private static final int MIN = 1;

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
        if (selectedTable <= TO_SCREEN_NULL || selectedTable > reservingMovie.getPlayScehdules().size()) {
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
        if (reservationNumber == TO_SCREEN_NULL || reservingMovie.getPlayScehdules().get(selectedTable).getCapacity() < reservationNumber) {
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

    public void printReservationList(List<ReservedMovie> reservedMovieList){
        for (ReservedMovie movie : reservedMovieList){
            System.out.println(movie);
        }
    }


    public boolean checkIfOneHourWithinRange(List<Movie> reservedMovie, LocalDateTime dateTimetoCheck, int selectedTable) {
        boolean isOneHourWithinRange = false;
        if (reservedMovie.size() != TO_SCREEN_NULL && reservedMovie.size() > MIN){
            for (Movie movie : reservedMovie) {
                LocalDateTime movieTimeToCheck = movie.getPlayScehdules().get(selectedTable).getStartDateTime();
                isOneHourWithinRange = DateTimeUtils.isOneHourWithinRange(movieTimeToCheck, dateTimetoCheck);
            }

        }

        return isOneHourWithinRange;

    }

    public boolean checkIfMovieSame(List<Movie> reservedMovie, int movieIdReserving) {
        boolean isSameMovie = false;
        if (reservedMovie.size() != TO_SCREEN_NULL && reservedMovie.size() > MIN){
            for (Movie movie : reservedMovie) {
                isSameMovie = movie.checkMovieId(movieIdReserving);
            }
        }
        return isSameMovie;
    }

    public void printPaymentAmount(List<ReservedMovie> reservedMovieList,int amountOfPointToUse,int payByCreditOrCash){
        int amount = 0;
        for (ReservedMovie reservedMovie : reservedMovieList){
            amount += reservedMovie.getMovie().getPrice() * reservedMovie.getReservingNumber();
        }
        amount -= amountOfPointToUse;
        if (payByCreditOrCash == 1){
            amount *= 0.95;
        }
        if (payByCreditOrCash ==2){
            amount *= 0.98;
        }
        System.out.println(String.format("최종 결제한 금액은 %d원 입니다.\n",amount) + "예매를 완료했습니다. 즐거운 영화관람되세요");
    }



    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        MovieApplication m = new MovieApplication();
        List<Movie> reservedMovie = new ArrayList<>();

        boolean isReservationEnd = false;
        boolean isOneHourWithinRange = false;
        boolean isSameMovie = false;


        List<ReservedMovie> reservedMovieList = new ArrayList<>();
        //TODO : 바깥 루프 필요함

        while (!isReservationEnd) {
            int movieId = InputView.inputMovieId();
            m.printSelectedMovieInfo(movieId, movies);
            Movie movieReservingNow = m.movieSelection(movieId, movies);

            reservedMovie.add(m.movieSelection(movieId, movies));

            int selectedTable = m.timeTableSelectionInput(movieReservingNow);

            LocalDateTime dateTimeToCheck = movieReservingNow.getPlayScehdules().get(selectedTable).getStartDateTime();

            isOneHourWithinRange = m.checkIfOneHourWithinRange(reservedMovie, dateTimeToCheck, selectedTable);
            isSameMovie = m.checkIfMovieSame(reservedMovie, movieId);

            if (isOneHourWithinRange) {
                System.out.println("상영 시간이 예매된 영화와 1시간 이내입니다. 다시 예매 해주세요.");
                continue;
            }
            if (isSameMovie) {
                System.out.println("기존 예매한 영화와 같은 영화입니다. 다른 영화로 예매 해주세요.");
                continue;
            }
            int reseravationNumber = m.reservingNumberInput(movieReservingNow, selectedTable);

            //LocalDaeTime과 예약 인원을 저장하는 객체 필요

            reservedMovieList.add(new ReservedMovie(movieReservingNow, dateTimeToCheck, reseravationNumber));

            int payOrAdditionalReservation = m.payOrAdditionalReservationInput();
            isReservationEnd = m.checkIfReservationEnd(payOrAdditionalReservation);
        }
        //예약이 끝낫다면,
        m.printReservationList(reservedMovieList);
        InputView.printPaymentRunningMessage();
        int amountOfPointToUse = InputView.inputAmountOfPointToUse();


        int payByCreditOrCash = InputView.inputPayByCreditCardOrCash();

        printPaymentAmount(reservedMovieList,amountOfPointToUse,payByCreditOrCash);

        //예약 내역 프린트. 이건 movie 정보를 받아야겟지


    }
    // TODO 구현 진행

}

