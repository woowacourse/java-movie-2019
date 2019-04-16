import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int ARRAY_DEFAULT_VALUE = -1;
    private static final int QUIT_SIGNAL = 1;
    private static final int CONTINUE_SIGNAL = 2;

    private static List<Reservation> reservations;
    private static boolean isReserving;

    public static void main(String[] args) {
        isReserving = true;
        reservations = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();

        while (isReserving) {
            OutputView.printMovies(movies);
            makeReservation(movies);
        }

        OutputView.printReservations(reservations);

        int point = InputView.inputPoint();
        InputView.inputPayMethod();

        OutputView.printReceipt(reservations, point);
    }

    public static void makeReservation(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        OutputView.printMovie(findMovieById(movies, movieId));
        int tableId = InputView.inputMovieTable() + ARRAY_DEFAULT_VALUE;
        int numPeople = InputView.inputNumPeople();
        confirmReservation(findMovieById(movies, movieId), tableId, numPeople);
        enterQuitOrContinue();
    }

    public static boolean enterQuitOrContinue() {
        int quitSignal = InputView.inputQuitSignal();
        if (quitSignal == QUIT_SIGNAL) {
            isReserving = false;
            return true;
        } else if (quitSignal == CONTINUE_SIGNAL)
            return false;

        OutputView.printInputWrongValueMessage();
        return enterQuitOrContinue();
    }

    public static Movie findMovieById(List<Movie> movieList, int movieId) {
        for (Movie movie : movieList)
            if (movie.isSameMovieId(movieId))
                return movie;

        return null;
    }

    public static boolean confirmReservation(Movie movie, int movieTable, int numPeople) {
        if (movie.makeReserve(movieTable, numPeople)) {
            reservations.add(new Reservation(movie, movieTable, numPeople));
            return true;
        }
        return false;
    }

}
