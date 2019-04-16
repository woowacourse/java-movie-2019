package view;

import java.util.List;

import domain.Movie;
import domain.PlaySchedule;

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
	
	public static void printBookingResult(Movie movie, PlaySchedule playSchedule, int capacity) {
		System.out.println("예약 내역");
		System.out.println(movie);
		System.out.println(playSchedule);
		System.out.println("예약 인원 : " + capacity);
	}
	
	public static void printBookingFinishMessage() {
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
	}
}
