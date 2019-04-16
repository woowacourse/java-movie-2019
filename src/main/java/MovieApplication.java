import java.util.List;
import java.util.Map;

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

public class MovieApplication {

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        InputView inputView = new InputView();
        List<Integer> movieIds = inputView.inputMovieIds();
        Map<Integer, Integer> movieSchedules = inputView.inputMovieSchedules();
    }
}
