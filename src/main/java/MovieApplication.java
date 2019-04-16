import Program.BookingMovie;
import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.awt.print.Book;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        BookingMovie bookingMovie = new BookingMovie(new BookMovie());
        bookingMovie.booking(movieId);
        System.out.println(bookingMovie.bookMovie);
    }
}
