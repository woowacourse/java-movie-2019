package view;

import java.util.Scanner;

public class InputView {
	private static final String MOVIE_ID_INPUT_MESSAGE = "## 예약할 영화를 선택하세요.";
	private static final String SCHEDULE_INPUT_MESSAGE = "## 예약할 시간표를 선택하세요. (첫 번째 상영 시간이 1번)";
	private static final String NUMBER_OF_AUDIENCE_INPUT_MESSAGE = "## 예약할 인원를 입력하세요.";
	private static final String ADDITIONAL_RESERVATION_FLAG_INPUT_MESSAGE = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
	private static final String POINT_INPUT_MESSAGE = "## 포인트 사용금액을 입력하세요.포인트가 없으면 0 입력";
	private static final String PAYMENT_FLAG_INPUT_MESSAGE = "## 신용카드는 1번, 현금은 2번";
	
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
	
	public static int inputAdditionalReservationFlag() {
		System.out.println(ADDITIONAL_RESERVATION_FLAG_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputAdditionalReservationFlag();
		}
	}
	
	public static int inputPoint() {
		System.out.println(POINT_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputPoint();
		}
	}
	
	public static int inputPaymentFlag() {
		System.out.println(PAYMENT_FLAG_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputPaymentFlag();
		}
	}
}
