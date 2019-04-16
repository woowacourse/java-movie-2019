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

        booker.selectMovie();
        OutputView.printMovie(booker.currentBookingMovieId());
        booker.selectBookingTime();
        booker.selectBookingNumber();
    }
}
