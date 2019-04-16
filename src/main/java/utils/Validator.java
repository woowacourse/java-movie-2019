package utils;

import java.time.LocalDateTime;
import java.util.List;

import domain.Movie;
import domain.PlaySchedule;
import view.OutputView;

public class Validator {

	public static boolean checkMovieTimeValid(List<PlaySchedule> playScheduleList, int timeId) {
		if (timeId < 1 || playScheduleList.size() < timeId) {
			OutputView.printUserInputAgainNoMovieTime();
			return false;
		}

		if (!DateTimeUtils.isBeforeNowThanMovieTime(playScheduleList.get(timeId - 1).getStartDateTime(), LocalDateTime.now())) {
			OutputView.printUserInputAgainMovieTimePass();
			return false;
		}
		return true;
	}

	public static boolean checkMovieReservationNumberValid(Movie movie, int movieTimeIdx, int reservationNumber) {
		int maxReservationNumber = movie.getPlaySchedules().get(movieTimeIdx).getCapacity();

		if (reservationNumber <= 0 || maxReservationNumber < reservationNumber) {
			return false;
		}
		return true;
	}
}
