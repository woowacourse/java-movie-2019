import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static final int TO_BE_EXITED = 2;
	public static final int TO_BE_CONTINUED = 1;
	
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		
		while(makeReservation() != TO_BE_EXITED) {
			
		}
		
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
