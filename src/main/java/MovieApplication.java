import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.ReservationList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static final int TO_BE_EXITED = 2;
	public static final int TO_BE_CONTINUED = 0;

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		

		while (makeReservation() != TO_BE_CONTINUED) {

		}

		OutputView.printReservation(ReservationList.getReservations());
	}

	public static int makeReservation() {
		OutputView.printMovies(MovieRepository.getMovies());
		int movieId = InputView.inputMovieId();
		Movie movieToReserve = MovieRepository.getMovie(movieId);
		OutputView.printSelectedMovie(movieToReserve);
		int movieTime = InputView.inputMovieTime(movieToReserve);
		List<PlaySchedule> playSchedules = movieToReserve.getPlaySchedules();
		int moviePeople = InputView.inputMoviePeople();
		if (InputView.inputCalculateOrAddMovie() == 2) {
			return 1;
		}
		return 0;

	}

}
