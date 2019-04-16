package utils;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reservation;

public class Validator {
	private static final String NUMBER_PATTERN = "^[0-9]*$";
	private static final String FLAG_PATTERN = "[12]";
	private static final int ONLY_ONE = 1;

	public static boolean isNaturalNumber(String value) {
		if (value == null || value.length() == 0 ||
			!Pattern.matches(NUMBER_PATTERN, value) ||
			Integer.parseInt(value.trim()) < 0) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static boolean isValidMovieId(String value, List<Reservation> reservations) {
		if (!isNaturalNumber(value) ||
			!MovieRepository.contains(Integer.parseInt(value)) ||
			!isOneHourWithinRangeAllReservation(reservations)) {
			System.out.println("존재하지 않는 영화입니다. 다시 입력해주세요");
			return false;
		}
		return true;
	}

	private static boolean isOneHourWithinRangeAllReservation(List<Reservation> reservations) {
		Collections.sort(reservations);
		int reservationSize = reservations.size();
		if (reservationSize <= ONLY_ONE) {
			return true;
		}
		if (!DateTimeUtils.isOneHourWithinRange(reservations.get(0).getPlaySchedule().getStartDateTime(),
			reservations.get(reservationSize - 1).getPlaySchedule().getStartDateTime())) {
			return false;
		}
		return true;
	}

	public static boolean isValidPlaySchedule(String value, Movie movie) {
		if (!isNaturalNumber(value) ||
			!movie.isLessThanPlayScheduleSize(Integer.parseInt(value))) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static boolean isValidCapacity(String value, PlaySchedule playSchedule) {
		if (!isNaturalNumber(value) ||
			!playSchedule.isLessThanCapacity(Integer.parseInt(value))) {
			System.out.println("예약 가능 인원보다 많습니다.");
			return false;
		}
		return true;
	}

	public static boolean isValidFlag(String value) {
		if (!isNaturalNumber(value) ||
			!Pattern.matches(FLAG_PATTERN, value)) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static void printWrongInput() {
		System.out.println("잘 못 입력했습니다.");
	}
}
