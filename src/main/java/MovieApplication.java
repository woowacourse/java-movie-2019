import domain.Movie;
import domain.MovieRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        Movie selectedMovie = MovieRepository.getMovieUsingMovieID(movieId);
        OutputView.printSelectedMovie(selectedMovie);

        int moveStartTimeNumber = InputView.inputMovieStartTime();
        int numberOfPeople = InputView.inputNumberOfPeople();
    }
}
