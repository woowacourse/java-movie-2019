package view;

import java.util.List;
import java.util.Scanner;

import domain.Movie;
import domain.MovieRepository;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String REQ_ID = "## 예약할 영화를 선택하세요.";
	private static final String REQ_TIME = "## 예약할 시간표를 선택하세요." + "(첫번째 상영 시간이 1번)";
	private static final String REQ_PEOPLE = "## 예약할 인원을 입력하세요.";
	private static final String NOT_EXIST_MOVIE = "[오류] 현재 상영작이 아닌 id 입니다.";
	private static final String NOT_CORRECT_TIME = "[오류] 예매할 수 없는 시간차입니다.";
	private static final String NOT_CORRECT_PEOPLE = "[오류] 가능한 예매 인원이 아닙니다.";

	private static int stringToInteger() {
		return Integer.valueOf(scanner.nextLine().trim());
	}

	public static int inputMovieId() {
		try {
			System.out.println(REQ_ID);
			return isValidID(stringToInteger());
		} catch (Exception e) {
			System.out.println(NOT_EXIST_MOVIE);
			return inputMovieId();
		}
	}

	private static int isValidID(int inputId) {
		List<Integer> moviesId = MovieRepository.getMoviesId();
		if (moviesId.contains(inputId)) {
			return inputId;
		}
		throw new IllegalArgumentException();
	}

	public static int inputMovieTime(int movieId) {
		try {
			System.out.println(REQ_TIME);
			return isValidTime(movieId, stringToInteger());
		} catch (Exception e) {
			System.out.println(NOT_CORRECT_TIME);
			return inputMovieTime(movieId);
		}
	}

	private static int isValidTime(int movieId, int inputTime) {
		Movie movie = MovieRepository.getMovieById(movieId);
		if (movie.isValidTime(inputTime)) {
			return inputTime;
		}
		throw new IllegalArgumentException();
	}

	public static int inputMoviePeople(int movieId, int inputTime) {
		try {
			System.out.println(REQ_PEOPLE);
			return isValidPeople(movieId, inputTime, stringToInteger());
		} catch (Exception e) {
			System.out.println(NOT_CORRECT_PEOPLE);
			return inputMoviePeople(movieId, inputTime);
		}
	}

	private static int isValidPeople(int movieId, int inputTime, int inputPeople) {
		Movie movie = MovieRepository.getMovieById(movieId);
		if (movie.isValidPeople(inputTime, inputPeople)) {
			return inputPeople;
		}
		throw new IllegalArgumentException();
	}
}
