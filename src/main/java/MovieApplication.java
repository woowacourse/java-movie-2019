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
        while (!InputView.isValidId(movieId, movies)) {
        	System.out.println("상영목록에 없는 영화입니다.");
        	movieId = InputView.inputMovieId();
        }
        // TODO 구현 진행
        //
    }
}
