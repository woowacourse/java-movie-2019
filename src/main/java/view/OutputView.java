package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static Movie findMovie(List<Movie> movies, int movieId) {
		Movie selectedMovie = movies.get(0);
		for (Movie movie : movies) {
			if (movie.getId() == movieId)
				selectedMovie = movie;
		}
		System.out.println(selectedMovie);
		return selectedMovie;
	}

	public static void printSelectTime(Movie movie, int movieTime) {
		System.out.println(movie.getSchedule().get(movieTime));
	}

	public static void printResult(int payPrice) {
		System.out.println("최종 결제한 금액은 " + payPrice + "원 입니다.");
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
	}

}
