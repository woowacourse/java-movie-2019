package domain;

import java.util.InputMismatchException;

import view.InputView;
import view.OutputView;

public class MovieApplication {
	public static void main(String[] args) {
		OutputView.printMovies(MovieRepository.getMovies());
		OutputView.printMovie(InputView.inputMovieId());
	}
}
