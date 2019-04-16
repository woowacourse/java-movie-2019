package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printErrorMessage(Exception e) {
		String message = e.getMessage();
		if (message == null) {
			System.out.println("오류가 발생했습니다.");
		}
		System.out.println(message);
	}
}
