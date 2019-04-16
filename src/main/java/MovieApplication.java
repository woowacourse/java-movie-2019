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
        BookingMovie bookSystem = new BookingMovie(new BookMovie());

        BookMovie bookingMovie = bookSystem.booking(movieId);
        List<Movie> bookingMovieList = bookingMovie.getBookMovieList();
        OutputView.printMovies(bookingMovieList);

        int ScheduleNumber = InputView.inputMovieSchedule();
        bookSystem.selectSchedule(ScheduleNumber);


    }
}
