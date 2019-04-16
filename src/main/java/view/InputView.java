package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String WRONG_INPUT = "잘못된 입력입니다.";
	private static final String INPUT_MOVIE_ID_MESSAGE = "## 예약할 영화를 선택하세요.";
	private static final String INPUT_SCHEDULE_NUMBER_MESSAGE = "## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)";
	private static final String INPUT_TICKET_COUNT = "## 예약할 인원을 입력하세요.";

	public static int inputMovieId() {
		System.out.println(INPUT_MOVIE_ID_MESSAGE);
		try {
			return Integer.parseInt(scanner.next());
		} catch (Exception e) {
			System.out.println(WRONG_INPUT);
			return inputMovieId();
		}
	}

	public static int inputScheduleNumber() {
		System.out.println(INPUT_SCHEDULE_NUMBER_MESSAGE);
		try {
			return Integer.parseInt(scanner.next());
		} catch (Exception e) {
			System.out.println(WRONG_INPUT);
			return inputScheduleNumber();
		}
	}
	
	public static int inputTicketCount() {
		System.out.println(INPUT_TICKET_COUNT);
		try {
			return Integer.parseInt(scanner.next());
		} catch (Exception e) {
			System.out.println(WRONG_INPUT);
			return inputTicketCount();
		}
	}
}
