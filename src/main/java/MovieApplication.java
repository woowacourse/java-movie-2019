import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	static List<Movie> reservedMovies = new ArrayList<>();

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		int movieId = InputView.inputMovieId();
		// 예약할 영화 선택 기능
		System.out.println(MovieRepository.getSelectedMovies(movieId));
		int movieTime = InputView.inputMovieTime();
		// 예약할 시간표 선택 기능
		System.out.println(MovieRepository.getSelectedMovies(movieId).getPlaySchedules().get(movieTime-1));
	}
}
