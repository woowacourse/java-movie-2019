import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		Movie movie = MovieReservation.getUserMovie();
		OutputView.printMovie(movie);
		int movieTimeIdx = MovieReservation.getMoiveTime(movie);
		int reservationNumber = MovieReservation.getMovieReservationNumber(movie, movieTimeIdx);
		/* 테스트를 위한 출력 */
		System.out.println("예약 인원 수 : " + reservationNumber);
	}
}
