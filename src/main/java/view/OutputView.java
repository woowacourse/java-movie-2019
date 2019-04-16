package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printSelectError() {
		System.out.println("해당 ID의 영화가 없습니다. 다시 선택해 주세요.");
	}

	public static boolean printSelectMovie(Movie movie, int movieId) {
		if (movie.getId() == movieId) {
			System.out.println(movie);
			return true;
		}
		return false;
	}

	public static boolean findMovie(List<Movie> movies, int movieId) {
		boolean isContain = false;
		for (Movie movie : movies) {
			isContain |= printSelectMovie(movie, movieId);
		}
		if (!isContain)
			printSelectError();
		return isContain;
	}

	public static void printResult() {
		System.out.println("최종 결제한 금액은 " + "원 입니다.");
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
	}

}
