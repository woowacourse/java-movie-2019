package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final char NEW_LINE = '\n';

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return getInteger();
    }

    public static int inputScheduleId() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return getInteger();
    }

    public static int inputPersonCount() {
        System.out.println(NEW_LINE + "## 예약할 인원을 입력하세요.");
        return getInteger();
    }

    public static int inputAdditionalReservation() {
        System.out.println(NEW_LINE + "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return getInteger();
    }

    private static int getInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return getInteger();
        }
    }
}
