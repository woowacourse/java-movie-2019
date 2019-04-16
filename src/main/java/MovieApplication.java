import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Map<Integer,Movie> movieList = MovieRepository.getMovieMap();

        int movieId = InputView.inputMovieId();
        OutputView.printMovieInfo(movieList, movieId);
        int movieTime = InputView.inputSchedule(movieList.get(movieId));


        // TODO 구현 진행
    }
}
