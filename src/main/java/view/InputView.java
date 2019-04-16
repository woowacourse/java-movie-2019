package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputMovieId();
        }
    }

    public static int inputPlaySchedule() {
        try {
            System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputPlaySchedule();
        }
    }

    public static int inputCapacity() {
        try {
            System.out.println("##예약할인원을입력하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputCapacity();
        }
    }

    public static int inputContinueReservation() {
        try {
            System.out.println("##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputContinueReservation();
        }
    }

	public static int inputPoint() {
		try {
			System.out.println("##포인트사용금액을입력하세요.포인트가없으면0입력");
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
			return inputPoint();
		}
	}

	public static int inputPayType() {
		try {
			System.out.println("##신용카드는 1번, 현금은 2번");
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
			return inputPayType();
		}
	}
}
