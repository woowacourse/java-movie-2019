package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	static final String DEMAND_USER_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";

	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printUserInputAgain() {
		System.out.println(DEMAND_USER_INPUT_AGAIN);
	}
}