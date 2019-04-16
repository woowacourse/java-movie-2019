import domain.Movie;
import domain.MovieRepository;
import domain.MovieReserveManager;
import domain.ReservedMovie;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		MovieReserveManager movieResFerveManager = new MovieReserveManager();
		ReservedMovie reservedMovie = movieResFerveManager.getReservedMovie();
		movieResFerveManager.addReservedMovie(reservedMovie);
	}
}
