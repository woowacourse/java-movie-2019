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

        int movieSequence = InputView.InputMovieSchedule(movieId);
        int bookNum = InputView.InputBookingNumber(movieId, movieSequence);
        bookList.add(new Book(movieId, movieSequence, bookNum));
        //OutputView.printOnemovieSequence(movies, movieId, movieSequence);
        // TODO 구현 진행
    }
}
