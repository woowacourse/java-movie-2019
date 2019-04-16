import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        InputView inputView = new InputView();
        OutputView.printMovies(movies);

        int movieId = inputView.inputMovieId();

        // TODO 구현 진행
    }
}
