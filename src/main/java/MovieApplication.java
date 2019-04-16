import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;
import static utils.DateTimeUtils.format;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	static List<Movie> reservedMovies = new ArrayList<>();
	private static Movie selectedMovie;
	private static PlaySchedule selectedSchedule;

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		int movieId = InputView.inputMovieId();
		// 예약할 영화 선택 기능
		selectedMovie = MovieRepository.getSelectedMovies(movieId);
		int movieTime = InputView.inputMovieTime();
		// 예약할 시간표 선택 기능
		selectedSchedule = selectedMovie.getPlaySchedules(movieTime);
		// 예약할 인원 입력 기능
		int userCount = InputView.inputUserCount();
		Movie movie = new Movie(movieId, selectedMovie.getName(), selectedMovie.getPrice());
		reservedMovies.add(movie);
		System.out.println("예약내역\n" + movie + "\n시작시간: " + format(selectedSchedule.getStartDateTime()) + "\n예약인원: "
				+ userCount + "\n");

	}
}
