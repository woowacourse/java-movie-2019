package domain;

import view.InputView;

public class MovieReserveManager {
	private int inputValidatedMovieId() {
		int inputMovieId = new InputView().inputMovieId();
		if (!MovieRepository.getMovieIds().contains(inputMovieId))
			return inputValidatedMovieId();
		return inputMovieId;
	}

	private int inputValidatedMovieTime(Movie movie) {
		int inputMovieTime = new InputView().inputMovieTime();
		if (inputMovieTime > movie.getMovieCounts()) {
			System.out.println("존재하지 않는 시간입니다.");
			return inputValidatedMovieTime(movie);
		}
		return inputMovieTime;
	}
}
