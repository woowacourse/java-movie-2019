package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        int ret = scanner.nextInt();
        scanner.nextLine();
        return ret;
    }

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return inputInt();
    }

    public static int inputTime() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫법째 상영 영상이 1번)");
        return inputInt();
    }

    public static int inputCnt() {
        System.out.println("## 예약할 인원을 입력하세요.");
        return inputInt();
    }

    public static boolean inputExit() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return inputInt() == 1 ? true : false;
    }

    public static int inputPoint() {
        System.out.println("## 결제를 진행합니다.");
        System.out.println("## 포인트 사용 금액을 입력하세요. ");
        return inputInt();
    }

    public static int inputWay() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return inputInt();
    }
}
