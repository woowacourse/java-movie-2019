package view;

import java.util.List;

import domain.Movie;
import domain.PlaySchedule;
import domain.Reservation;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printMovie(Movie movie) {
		System.out.println(movie);
	}

	public static void printPlaySchedule(PlaySchedule playSchedule) {
		System.out.println(playSchedule);
	}

	public static void printAllReservation(List<Reservation> reservations) {
		reservations.forEach(reservation -> System.out.println(reservation));
	}

	public static void printBookingFinishMessage() {
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
	}
}
