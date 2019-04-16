import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
	}
		
	

	public static int makeReservation() {
		OutputView.printMovies(MovieRepository.getMovies());
		int movieId = InputView.inputMovieId();
		Movie movieToReserve = MovieRepository.getMovie(movieId);
		OutputView.printSelectedMovie(movieToReserve);
		int movieTime = InputView.inputMovieTime();
		int moviePeople = InputView.inputMoviePeople();
		if(InputView.inputCalculateOrAddMovie()==2) {
			return 1;
		}
		return 0;

	}
	
}
