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

        // TODO 구현 진행
        // 영화 선택
        Movie aMovie = MovieRepository.getMovieById(movieId);
        OutputView.printAMovie(aMovie);

        int movieTime = InputView.inputMovieTime();
        int reserveCount = InputView.inputReserveCount();

        int process = InputView.inputChooseProcess();
        OutputView.printReserveList(aMovie, movieTime, reserveCount);

        OutputView.printProcessMessage();

    }
}
