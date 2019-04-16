import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.InputView;
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
		int finishOrAddReservation = MovieReservation.getFinishReservationOrAddReservation();
		/* 테스트를 위한 출력 */
		System.out.println("종료 또는 추가 예약"+finishOrAddReservation);
	}
}
