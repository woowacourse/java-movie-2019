import domain.Movie;
import domain.MovieRepository;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        PrintUtils.printSelectedMovie(movies,movieId);
    }
}
