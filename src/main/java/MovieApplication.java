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

        OutputView.printMovie(findMovieById(movies, movieId));
    }

    public static Movie findMovieById(List<Movie> movieList, int movieId) {
        for (Movie movie : movieList) {
            if (movie.isSameMovieId(movieId))
                return movie;
        }

        return null;
    }
}
