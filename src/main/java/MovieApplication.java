import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<Movie> selectMovies = new ArrayList<>();
        Movie movie = null;

        do {
            int movieId = InputView.inputMovieId();
            movie = OutputView.printMovieSchedule(movies, movieId);
            selectMovies.add(movie);
        } while (movie == null);
    }
}
