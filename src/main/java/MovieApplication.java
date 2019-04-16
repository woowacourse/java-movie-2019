import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static Movie getMovieFromId(int movieId) {
        return MovieRepository.getMovie(movieId).get(0);
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<MovieReservation> reservations = new ArrayList<>();
        OutputView.printMovies(movies);
        boolean isContinue = true;

        while (isContinue) {
            int movieId = InputView.inputMovieId();
            Movie movie = getMovieFromId(movieId);
            System.out.println(movie);

            int scheduleId = InputView.inputScheduleId(reservations, movie);
            int reservationNumber
                    = InputView.inputReservationNumber(movie, scheduleId);

            MovieReservation reservation
                    = new MovieReservation(movie, scheduleId, reservationNumber);
            reservations.add(reservation);
        }
    }
}
