package domain;

import java.util.List;

import utils.DateTimeUtils;
import domain.PlaySchedule;

public class ErrorCheck {

	public static boolean isValidMovie(int movieId) {
		boolean result = false;
		List<Movie> movies = MovieRepository.getMovies();
		for (Movie movie : movies) {
			result |= (movie.getMovieId() == movieId);
		}
		if (!result) {
			System.out.println("Error! - 유효하지 않은 영화 번호 입니다! 다시 입력해주세요.");
		}
		return result;

	}

	public static boolean isValidPeople(int moviePeople) {
		boolean result = false;
		System.out.println("Error! - 예매 가능 인원 수를 초과하였습니다! 다시 입력해주세요.");
		return false;
	}

	/*
	 * public static boolean isWithinOneHour(Movie movie, int movieTime) {
	 * 
	 * boolean result = false; List<PlaySchedule> playSchedules =
	 * movie.getPlaySchedules(); List<Reservation> reservations =
	 * ReservationList.getReservations(); for (Reservation reservation :
	 * reservations) { result &= DateTimeUtils.isOneHourWithinRange(((PlaySchedule)
	 * playSchedules).getStartDateTime(),reservation.getTime()); } if (!result) {
	 * System.out.println("Error! - 영화 간의 시간 차이가 한시간이 넘습니다! 다시 입력해주세요."); }
	 * 
	 * return result; }
	 */

	public static boolean isValidTime(Movie movie, int movieTime) {
		boolean result = false;
		List<PlaySchedule> playSchedules = movie.getPlaySchedules();
		result |= (movieTime > 0);
		if (!result) {
			System.out.println("Error! - 이미 상영 시작된 영화입니다! 다시 입력해주세요.");
		}
		return result;
	}

}
