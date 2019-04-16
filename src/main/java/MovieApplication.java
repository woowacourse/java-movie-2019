import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie userMovie = InputView.inputMovieId();
        OutputView.printMovie(userMovie);



        // TODO 구현 진행
    }
}
