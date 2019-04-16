import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        /*int movieId = 0;
        do { movieId = InputView.inputMovieId(); }
        while (!selectMovie(movies, movieId));*/

        while (!selectMovie(movies, InputView.inputMovieId())) {};

        int scheduleNumber = InputView.inputMovieSchedule();
    }

    public static boolean selectMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.isSameId(movieId)) {
                System.out.println(movie.toString());
                return true;
            }
        }
        OutputView.notExistedMovie();
        return false;
    }
}