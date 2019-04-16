package service;

import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.Validator;
import view.InputView;
import view.OutputView;

public class MovieReservation {
	public static Movie getUserMovie() {
		int movieId = InputView.inputMovieId();
		Movie movie = MovieRepository.findMovie(movieId);

		while (movie == null) {
			OutputView.printUserInputAgainNoSearchMovie();
			movieId = InputView.inputMovieId();
			movie = MovieRepository.findMovie(movieId);
		}

		return movie;
	}

	public static void getMoiveTime(Movie movie){
		List<PlaySchedule> moviePlaySchedule = movie.getPlaySchedules();
		boolean result = Validator.checkMovieTimeValid(moviePlaySchedule, InputView.inputMovieTime());

		while(!result){
			result = Validator.checkMovieTimeValid(moviePlaySchedule, InputView.inputMovieTime());
		}

	}

}
