package service;

import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.Validator;
import view.InputView;
import view.OutputView;

import static view.OutputView.printUserInputAgainReservationFinishOrAddError;

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

	public static int getMoiveTime(Movie movie) {
		List<PlaySchedule> moviePlaySchedule = movie.getPlaySchedules();
		int movieTimeIdx = InputView.inputMovieTime();
		boolean result = Validator.checkMovieTimeValid(moviePlaySchedule, movieTimeIdx);

		while (!result) {
			movieTimeIdx = InputView.inputMovieTime();
			result = Validator.checkMovieTimeValid(moviePlaySchedule, movieTimeIdx);
		}
		return movieTimeIdx;
	}

	public static int getMovieReservationNumber(Movie movie, int movieTimeIdx) {
		int reservationNumber = InputView.inputReservationNumber();
		boolean result = Validator.checkMovieReservationNumberValid(movie, movieTimeIdx - 1, reservationNumber);

		while (!result) {
			OutputView.printUserInputAgainReservationNumberOver();
			reservationNumber = InputView.inputReservationNumber();
			result = Validator.checkMovieReservationNumberValid(movie, movieTimeIdx - 1, reservationNumber);
		}

		return reservationNumber;
	}

	public static int getFinishReservationOrAddReservation() {
		int finishOrAddNumber = InputView.inputFinishReservationOrAddReservation();
		boolean result = Validator.checkFinishReservationOrAddReservationNumberValid(finishOrAddNumber);

		while (!result) {
			printUserInputAgainReservationFinishOrAddError();
			finishOrAddNumber = InputView.inputFinishReservationOrAddReservation();
			result = Validator.checkFinishReservationOrAddReservationNumberValid(finishOrAddNumber);
		}

		return finishOrAddNumber;
	}

}
