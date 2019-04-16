package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId() {
		System.out.println("## 예약할 영화를 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputMovieTime() {
		System.out.println("## 예약할 시간표를 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputReservationNumber() {
		System.out.println("## 예약 할 인원을 입력하세요.");
		return scanner.nextInt();
	}

	public static int inputFinishReservationOrAddReservation(){
		System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번을 입력해주세요.");
		return scanner.nextInt();
	}

	public static int inputUserPoint(){
		System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력해주세요.");
		return scanner.nextInt();
	}
}
