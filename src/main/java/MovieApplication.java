import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int ARRAY_DEFAULT_VALUE = -1;

    public static void main(String[] args) {
        List<Reservation> reservations = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        OutputView.printMovie(findMovieById(movies, movieId));

        int tableId = InputView.inputMovieTable() + ARRAY_DEFAULT_VALUE;
        int numPeople = InputView.inputNumPeople();
        makeReservation(findMovieById(movies, movieId), tableId, numPeople);
        reservations.add(new Reservation(findMovieById(movies, movieId), tableId, numPeople));

        OutputView.printReservations(reservations);

        int point = InputView.inputPoint();
        InputView.inputPayMethod();

        OutputView.printReceipt(reservations, point);
    }

    public static Movie findMovieById(List<Movie> movieList, int movieId) {
        for (Movie movie : movieList)
            if (movie.isSameMovieId(movieId))
                return movie;

        return null;
    }

    public static boolean makeReservation(Movie movie, int movieTable, int numPeople) {
        return movie.makeReserve(movieTable, numPeople);
    }
}
