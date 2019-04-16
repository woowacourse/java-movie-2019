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
		if(MovieRepository.contains(movieId)) {
			
		}
		
//		int startDateTime = InputView.inputStartDateTime();
//		int capacity = InputView.inputCapacity();
//		int point = InputView.inputPoint();
//		int paymentMehotd = InputView.inputPaymentMethod();
		
		
	}
}
