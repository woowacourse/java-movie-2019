import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

public class MovieApplication {

	private List<Reservation> reservations = new ArrayList();

	private void printMovies() {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		requestMovieId();
	}

	private void requestMovieId() {
		int movieId = InputView.inputMovieId();
		OutputView.printMovie(movieId);
		requestMovieTime(movieId);
	}

	private void requestMovieTime(int movieId) {
		int inputTime = InputView.inputMovieTime(movieId);
		int inputPeople = InputView.inputMoviePeople(movieId, inputTime);
		reservations.add(new Reservation(movieId, inputTime, inputPeople));
		printAll();
	}
	
	private void printAll() {
		for(Reservation resv : reservations) {
			System.out.println(resv);
		}
	}
	
	public static void main(String[] args) {
		new MovieApplication().printMovies();
	}
}
