import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;
import utils.Input;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        int movieId = Input.idInput();
        Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
        OutputView.printSelectedMovie(selectedMovie);
        int movieTime = Input.timeInput(selectedMovie);

    }
}
