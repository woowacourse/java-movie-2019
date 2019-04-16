import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {

    private static final int RESERVATION_FINISHED = 1;
    private static final int ADDITIONAL_RESERVATION = 2;

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
        if (selectedTable <= 0 || selectedTable >= reservingMovie.getPlayScehdules().size()) {
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
        if (reservationNumber == 0 || reservingMovie.getPlayScehdules().get(selectedTable).getCapacity() < reservationNumber) {
            throw new IllegalArgumentException("예약 인원을 입력하지 않았거나 예약 가능 인원을 초과하였습니다. 다시 입력해 주세요.");
        }
    }

    public int payOrAdditionalReservationInput(){
        try {
            int payOrReservation = InputView.inputPayOrAdditionalReservation();
            checkIfPayOrReservationIsProper(payOrReservation);
            return payOrReservation;

        } catch(InputMismatchException | IllegalArgumentException e){
            System.out.println(e.getMessage());
            return payOrAdditionalReservationInput();
        }
    }

    public void checkIfPayOrReservationIsProper(int payOrReservation){
        if (payOrReservation < RESERVATION_FINISHED || payOrReservation > ADDITIONAL_RESERVATION){
            throw new IllegalArgumentException("1 또는 2의 숫자를 입력해주세요.");
        }
    }


    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        MovieApplication m = new MovieApplication();
        List<Movie> reservedMovie = new ArrayList<>();
        //movie List 를 가져와서 파싱하면서 해결해야함.
        //ID를 받아서,

        //MovieRepository.printMovieInfo(movieId);
        //Id 에 맞는 무비 정보를 가져온다.
        //해당 무비의 info를 출력한다.
        //해당 무비의 플레이스케쥴을, 새로운 List에 추가한다.
        //해당 리스트를 돌면서,
        /*for (Movie movie : movies){
            movie.getPlayScehdules().get[selectedTable];
            for (PlaySchedule playSchedule : movie.)
        }*/
        //TODO : 바깥 루프 필요함
        m.printSelectedMovieInfo(movieId, movies);
        Movie reservingMovie = m.movieSelection(movieId, movies);
        reservedMovie.add(m.movieSelection(movieId, movies));
        int selectedTable = m.timeTableSelectionInput(reservingMovie);
        //reservingMovie 가 주요 객체다
        int reseravationNumber = m.reservingNumberInput(reservingMovie, selectedTable);
        int payOrAdditionalReservation = m.payOrAdditionalReservationInput();


        if (payOrAdditionalReservation == ADDITIONAL_RESERVATION){
            //TODO : 위로 돌아감
        }
        if (payOrAdditionalReservation == RESERVATION_FINISHED){
            //printReservationList(reservedMovie);
            InputView.printPaymentRunningMessage();
            int amountOfPointToUse = InputView.inputAmountOfPointToUse();
            int payByCreditOrCash = InputView.inputPayByCreditCardOrCash();
        }


        //예약 내역 프린트. 이건 movie 정보를 받아야겟지




    }
    // TODO 구현 진행

}

