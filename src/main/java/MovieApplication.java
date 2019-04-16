import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	static final int ADD_RESERVATION = 2;

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		int finishOrAddReservation;
		int reservationNumber;
		Movie movie;

		do {
			movie = MovieReservation.getUserMovie();
			OutputView.printMovie(movie);
			int movieTimeIdx = MovieReservation.getMoiveTime(movie);
			reservationNumber = MovieReservation.getMovieReservationNumber(movie, movieTimeIdx);
			finishOrAddReservation = MovieReservation.getFinishReservationOrAddReservation();
		}
		while (finishOrAddReservation == ADD_RESERVATION);

		int userPoint = MovieReservation.getUserPoint(movie, reservationNumber);

		System.out.println("테스트를 위한 출력" + userPoint);
	}
}