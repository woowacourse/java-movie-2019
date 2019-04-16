package view;

import java.util.List;

import domain.Movie;

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
}
