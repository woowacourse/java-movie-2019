import domain.Movie;
import domain.MovieRepository;
//import view.InputView;
//import view.OutputView;
import view.*;
import utils.*;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();

        while (true) {
            OutputView.printMovies(movies);
            int movieId = InputView.inputMovieId();

            OutputView.printMovieSchedule(movies, movieId);
            int movieTime = InputView.inputMovieTime(movieId);

            int movieHeadCount = InputView.inputMovieHead(movieId, movieTime);
            int moviePayCheck = InputView.inputPayment();
            if (moviePayCheck == 1) {
                break;
            }
       }
        // TODO 구현 진행
    }
}
