import domain.Booker;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Booker booker = new Booker();

        int movieId = InputView.inputMovieId();
        OutputView.printMovie(movieId);

        booker.selectMovie(movieId);
        booker.selectBookingTime();
        booker.selectBookingNumber();
    }
}
