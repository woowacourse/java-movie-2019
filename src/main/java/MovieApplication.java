import domain.Movie;
import domain.MovieRepository;
import utils.ValidatorUtils;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        while (!ValidatorUtils.isNaturalMovieId(movieId)) {
            System.out.println("상영목록에 없는 영화를 선택했습니다.\n");
            movieId = InputView.inputMovieId();
        }

        OutputView.printMovie(movies, movieId);


    }
}
