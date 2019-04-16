package view;

import java.util.List;
import java.util.Scanner;

import domain.Movie;
import domain.PlaySchedule;
import domain.Reservation;
import utils.Validator;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMovieId(List<Reservation> reservations) {
		System.out.println("## 예약할 영화를 선택하세요.");
		String inputValue = SCANNER.nextLine();
		if (Validator.isValidMovieId(inputValue, reservations)) {
			return Integer.parseInt(inputValue);
		}
		return inputMovieId(reservations);
	}

	public static int inputStartDateTime(Movie movie) {
		System.out.println("## 예약할 시간표를  선택하세요.");
		String inputValue = SCANNER.nextLine();
		if (Validator.isValidPlaySchedule(inputValue, movie)) {
			return Integer.parseInt(inputValue);
		}
		return inputStartDateTime(movie);
	}

	public static int inputCapacity(PlaySchedule playSchedule) {
		System.out.println("## 예약할 인원을 입력하세요.");
		String inputValue = SCANNER.nextLine();
		if (Validator.isValidCapacity(inputValue, playSchedule)) {
			return Integer.parseInt(inputValue);
		}
		return inputCapacity(playSchedule);
	}

	public static int inputMoreBookingFlag() {
		System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
		String inputValue = SCANNER.nextLine();
		if (Validator.isValidFlag(inputValue)) {
			return Integer.parseInt(SCANNER.nextLine());
		}
		return inputMoreBookingFlag();
	}

	public static int inputPoint() {
		System.out.println("## 결제를 진행합니다.");
		System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
		String inputValue = SCANNER.nextLine();
		if (Validator.isNaturalNumber(inputValue)) {
			return Integer.parseInt(inputValue);
		}
		return inputPoint();
	}

	public static int inputPaymentMethod() {
		System.out.println("## 신용카드는 1번, 현금은 2번");
		String inputValue = SCANNER.nextLine();
		if (Validator.isValidFlag(inputValue)) {
			return Integer.parseInt(SCANNER.nextLine());
		}
		return inputPaymentMethod();
	}

}
