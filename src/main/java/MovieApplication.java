import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieRepository movierep = new MovieRepository();
        OutputView.printMovies(movies);
        int movieId;
        
        do {
        	movieId = InputView.inputMovieId();
		} while (!movierep.isMovie(movieId));
    }
}
