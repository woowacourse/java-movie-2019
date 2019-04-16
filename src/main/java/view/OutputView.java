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
	
	public static void printPlaySchedule(Movie movie, int startDateTime) {
		System.out.println(movie.getPlaySchedules().get(startDateTime - 1));
	}
	
	public static void printBookingResult(Movie movie, PlaySchedule playSchedule, int capacity) {
		System.out.println("예약 내역");
		System.out.println(movie);
		System.out.println(playSchedule);
		System.out.println("예약 인원 : " + capacity);
	}
}
