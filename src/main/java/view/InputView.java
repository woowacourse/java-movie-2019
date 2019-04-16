package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputMovieId();
        }
    }

    public static int inputMovieTime() {
        try {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputMovieTime();
        }
    }

    public static int inputReserveCount() {
        try {
            System.out.println("## 예약할 인원을 입력하세요");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputReserveCount();
        }
    }

    public static int inputChooseProcess() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputChooseProcess();
        }
    }

    public static int inputPointAmount() {
        try {
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputPointAmount();
        }
    }

    public static int inputPayType() {
        try {
            System.out.println("## 신용카드는 1번, 현금은 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputPayType();
        }
    }
}
