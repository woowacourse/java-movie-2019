import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    List<Movie> movies = MovieRepository.getMovies();
    List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        MovieApplication app = new MovieApplication();
        app.play();
    }

    private void play() {
        do {
            Reservation reservation = doReservation();
            reservations.add(reservation);
        } while (doAgain());
    }

    private Reservation doReservation() {
        OutputView.printMovies(movies);
        int movieId = getMovieId();
        OutputView.printSelectedMovie(MovieRepository.getMovie(movieId));
        int movieTime = getMovieTime(movieId);
        int numOfGuest = getNumOfGuest(movieId, movieTime);
        return new Reservation(movieId, movieTime, numOfGuest);
    }

    private int getMovieId() {
        try {
            int movieId = InputView.inputMovieId();
            Validator.checkMovieId(movieId);
            return movieId;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieId();
        }
    }

    private int getMovieTime(int movieId) {
        try {
            int movieTime = InputView.inputMovieTime();
            Validator.checkMovieTime(movieId, movieTime);
            return movieTime;
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieTime(movieId);
        }
    }

    private int getNumOfGuest(int movieId, int movieTime)  {
        try {
            int numOfGuest = InputView.inputNumOfGuest();
            Validator.checkNumOfGuest(movieId, movieTime, numOfGuest);
            return numOfGuest;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getNumOfGuest(movieId, movieTime);
        }
    }

    private boolean doAgain() {
        int quitOrDoAgain = getQuitOrDoAgain();
        return quitOrDoAgain == 2 ? true : false;
    }

    private int getQuitOrDoAgain() {
        try {
            int quitOrDoAgain = InputView.inputQuitOrDoAgain();
            Validator.checkQuitOrDoAgain(quitOrDoAgain);
            return quitOrDoAgain;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getQuitOrDoAgain();
        }
    }
}