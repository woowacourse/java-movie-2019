import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId(); // 보고 싶은 영화의 숫자 입력 받음
        // TODO 구현 진행
        OutputView.printSelectMovie(movies, movieId);
    }
}
