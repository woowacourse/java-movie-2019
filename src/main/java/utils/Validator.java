package utils;

import java.time.LocalDateTime;
import java.util.List;

import domain.PlaySchedule;
import view.OutputView;

public class Validator {

	public static boolean checkMovieTimeValid(List<PlaySchedule> playScheduleList, int timeId) {
		if (timeId < 1 || playScheduleList.size() < timeId) {
			OutputView.printUserInputAgainNoMovieTime();
			return false;
		}

		if (!DateTimeUtils.isBeforeNowThanMovieTime(playScheduleList.get(timeId-1).getStartDateTime(), LocalDateTime.now())) {
			OutputView.printUserInputAgainMovieTimePass();
			return false;
		}
		return true;
	}
}
