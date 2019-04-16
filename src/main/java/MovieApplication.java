import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		do {
			int movieId = InputView.inputMovieId();
			if (!OutputView.findMovie(movies, movieId))
				continue;
			int movieTime = InputView.inputMovieTime();
			int ticketNum = InputView.ticketNum();
			if (!InputView.inputStopOrGo())
				;
			break;
		} while (true);

		int point = InputView.inputPoint();
		int cardOrCash = InputView.inputCardOrCash();
		OutputView.printResult();
	}
}
