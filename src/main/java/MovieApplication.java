import domain.Movie;
import domain.MovieRepository;
import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MovieApplication app = new MovieApplication();
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = app.getMovieId();
    }

    private int getMovieId() {
        try {
            int movieId = InputView.inputMovieId();
            Validator.checkMovieId(movieId);
            return movieId;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieId();
        }
    }
}
