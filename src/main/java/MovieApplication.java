import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        int movieId;
        int scheduleNumber;

        OutputView.printMovies(movies);

        movieId = InputView.inputMovieId();

        OutputView.printMovie(movies, movieId);

        scheduleNumber = InputView.inputScheduleNumber(movieId);

    }
}
