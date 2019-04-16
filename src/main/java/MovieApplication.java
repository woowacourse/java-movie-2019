import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public void showAllMovieInfo() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private void selectMovieToReserve() {
        int movieId = InputView.inputMovieId();
        OutputView.printMovie(movieId);
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.showAllMovieInfo();
        movieApplication.selectMovieToReserve();
    }
}
