package view;

import java.util.Scanner;

public class InputView {
	private static final String MOVIE_ID_INPUT_MESSAGE = "## 예약할 영화를 선택하세요.";
	private static final String SCHEDULE_INPUT_MESSAGE = "## 예약할 시간표를 선택하세요. (첫 번째 상영 시간이 1번)";
	private static final String NUMBER_OF_AUDIENCE_INPUT_MESSAGE = "## 예약할 인원를 입력하세요.";
	
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMovieId() {
		System.out.println(MOVIE_ID_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputMovieId();
		}
	}
	
	public static int inputSchedule() {
		System.out.println(SCHEDULE_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputSchedule();
		}
	}
	
	public static int inputNumOfAudience() {
		System.out.println(NUMBER_OF_AUDIENCE_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputNumOfAudience();
		}
	}
}
