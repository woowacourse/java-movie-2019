package service;

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

public class MovieReservation {
	public static Movie getUserMovie() {
		int movieId = InputView.inputMovieId();
		Movie movie = MovieRepository.findMovie(movieId);

		while (movie == null) {
			OutputView.printUserInputAgain();
			movieId = InputView.inputMovieId();
			movie = MovieRepository.findMovie(movieId);
		}

		return movie;
	}
}
