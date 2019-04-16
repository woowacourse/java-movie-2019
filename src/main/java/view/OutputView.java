package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	static final String NO_SEARCH_MOVIE = "상영 목록에 없는 영화입니다. 다시 입력해주세요.";
	static final String NO_MOIVE_TIME = "상영 시간표에 없는 번호입니다. 다시 입력해주세요.";
	static final String MOIVE_TIME_PASS = "시작 시간이 지난 영화입니다. 다시 입력해주세요.";
	static final String RESERVATION_NUMBER_OVER = "올바르지않은 예약 인원 입력입니다. 다시 입력해주세요.";
	static final String RESERVATION_FINISH_OR_ADD_ERROR = "올바르지 않은 입력입니다. 다시 입력해주세요.";
	static final String PAYMENT_MOVIE = "## 결제를 진행합니다.";
	static final String USER_POINT_ERROR = "올바르지 않은 포인트 입력입니다. 다시 입력해주세요.";
	static final String USER_POINT_OVER = "결제 금액보다 포인트 사용이 많습니다. 다시 입력해주세요.";

	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printMovie(Movie movie) {
		System.out.println(movie);
	}

	public static void printUserInputAgainNoSearchMovie() {
		System.out.println(NO_SEARCH_MOVIE);
	}

	public static void printUserInputAgainNoMovieTime() {
		System.out.println(NO_MOIVE_TIME);
	}

	public static void printUserInputAgainMovieTimePass() {
		System.out.println(MOIVE_TIME_PASS);
	}

	public static void printUserInputAgainReservationNumberOver(){
		System.out.println(RESERVATION_NUMBER_OVER);
	}

	public static void printUserInputAgainReservationFinishOrAddError(){
		System.out.println(RESERVATION_FINISH_OR_ADD_ERROR);
	}

	public static void printPayMentMovie(){
		System.out.println(PAYMENT_MOVIE);
	}

	public static void printUserInputAgainMoviePointError(){
		System.out.println(USER_POINT_ERROR);
	}

	public static void printUserInputAgainMoviePointOver(){
		System.out.println(USER_POINT_OVER);
	}
}