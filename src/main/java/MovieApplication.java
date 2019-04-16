import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

import static domain.MovieRepository.getMovies;

public class MovieApplication {

    private final int SET_MOVIE_LOCATION = 1;

    private void printMovieList(int movieId){

        System.out.println(getMovies().get(movieId - SET_MOVIE_LOCATION));
    }
    public static void main(String[] args) {
        List<Movie> movies = getMovies();
        OutputView.printMovies(movies);
        MovieApplication movieCompany = new MovieApplication();

        int movieId = InputView.inputMovieId();
        movieCompany.printMovieList(movieId);

        // TODO 구현 진행
    }

}
