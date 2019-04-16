import Program.BookSystem;
import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        BookSystem bookSystem = new BookSystem(new BookMovie());

        BookMovie bookingMovie = bookSystem.booking(movieId);
        List<Movie> bookingMovieList = bookingMovie.getBookMovieList();
        OutputView.printMovies(bookingMovieList);

        int ScheduleNumber = InputView.inputMovieSchedule();
        bookSystem.selectSchedule(0,ScheduleNumber);

        int inputPeopleBooking = InputView.inputPeopleBooking();
        bookSystem.selectPeopleBooking(inputPeopleBooking);
        System.out.println(bookingMovie);




    }
}
