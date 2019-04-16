import domain.Movie;
import domain.MovieRepository;
import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        MovieApplication app = new MovieApplication();
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = app.getMovieId();
        OutputView.printSelectedMovie(MovieRepository.getMovie(movieId));
        int movieTime = app.getMovieTime(movieId);
        int numOfGuest = app.getNumOfGuest(movieId, movieTime);
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

    private int getMovieTime(int movieId) {
        try {
            int movieTime = InputView.inputMovieTime();
            Validator.checkMovieTime(movieId, movieTime);
            return movieTime;
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieTime(movieId);
        }
    }

    private int getNumOfGuest(int movieId, int movieTime)  {
        try {
            int numOfGuest = InputView.inputNumOfGuest();
            Validator.checkNumOfGuest(movieId, movieTime, numOfGuest);
            return numOfGuest;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getNumOfGuest(movieId, movieTime);
        }
    }
}