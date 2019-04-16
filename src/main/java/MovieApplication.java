import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;
import view.ReservatingMovie;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<Movie> reservatedMovies = InputView.inputMovieId();
        OutputView.printMovies(reservatedMovies);

        // TODO 구현 진행
    }
}
