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
			OutputView.findMovie(movies, movieId);
			int movieTime = InputView.inputMovieTime();
			int ticketNum = InputView.ticketNum();
		} while (InputView.inputStopOrGo());
		int point = InputView.inputPoint();
		int cardOrCash = InputView.inputCardOrCash();
	}
}
