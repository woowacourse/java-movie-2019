package domain;

import view.OutputView;

public class MovieApplication {
	public static void main(String[] args) {
		OutputView.printMovies(MovieRepository.getMovies());
	}
}
