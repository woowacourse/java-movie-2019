import domain.Movie;
import domain.MovieRepository;
import java.util.ArrayList;
import view.InputView;
import view.OutputView;
import domain.Book;

import java.util.List;

public class MovieApplication {
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        OutputView.printOneMovie(movies, movieId);

        int movieSchedule = InputView.InputMovieSchedule(movieId);
        int bookNum = InputView.InputBookingNumber();
        bookList.add(new Book(movieId, movieSchedule, bookNum));
        //OutputView.printOneMovieSchedule(movies, movieId, movieSchedule);
        // TODO 구현 진행
    }
}
