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
		if (reservations.size() > 0) {
			checkTimeGap(inputTime, movieId);
		}
		int inputPeople = InputView.inputMoviePeople(movieId, inputTime);
		reservations.add(new Reservation(movieId, inputTime, inputPeople));

		selectOption();
	}

	private boolean checkTimeGap(int inputTime, int movieId) {
		return true;
	}

	private void selectOption() {
		int option = InputView.inputCheckReservation();
		if (option == 2) {
			printMovies();
		}
		if (option == 1) {
			printReservations();
		}
	}

	private void printReservations() {
		for (Reservation resv : reservations) {
			System.out.println(resv);
		}
	}

	public static void main(String[] args) {
		new MovieApplication().printMovies();
	}
}
