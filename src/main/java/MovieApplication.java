import domain.Movie;
import domain.MovieRepository;
import input.MovieInput;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        //int movieId = InputView.inputMovieId();

        // TODO 구현 진행

        MovieInput movieInput = new MovieInput(movies, "8");
    }
}
