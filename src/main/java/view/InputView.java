package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int inputMovieScheduleNumber() {
        try {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieScheduleNumber();
        }
    }

    public static int inputTheNumberOfPerson() {
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTheNumberOfPerson();
        }
    }

    public static int inputAdditionalReserveOrNot() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputAdditionalReserveOrNot();
        }
    }

    public static int inputPoint() {
        try {
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPoint();
        }
    }

    public static int inputPaymentMethod() {
        try {
            System.out.println("## 신용카드는 1번, 현금은 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPoint();
        }
    }
}
