import domain.Movie;
import domain.MovieBookingMachine;
import domain.MovieSchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        MovieBookingMachine movieBookingMachine = new MovieBookingMachine();
        List<Movie> movies = movieBookingMachine.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        int playSchedule = InputView.inputPlaySchedule();
        int personNumber = InputView.inputMovieCapacity();

        MovieSchedule movieSchedule = new MovieSchedule(movieId, playSchedule, personNumber);
        movieBookingMachine.book(movieSchedule, personNumber);
    }
}
