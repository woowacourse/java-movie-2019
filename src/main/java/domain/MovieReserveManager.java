package domain;

import view.InputView;

public class MovieReserveManager {
	private int inputValidatedMovieId() {
		int inputMovieId = new InputView().inputMovieId();
		if (!MovieRepository.getMovieIds().contains(inputMovieId))
			return inputValidatedMovieId();
		return inputMovieId;
	}
}
