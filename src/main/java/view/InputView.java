package view;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieSchedule() {
        System.out.println("## 예약할 시간표를 선택해 주세요.");
        return scanner.nextInt();
    }

    public static int inputPeopleBooking() {
        System.out.println("## 예약할 인원을 입력 해주세요.");
        return scanner.nextInt();
    }

    public static double inputPoint() {
        System.out.println("## 포인트를 사용하시려면 입력하세요 포인트가 없으면 0 입력.");
        return scanner.nextDouble();
    }

    public static int inputPaymentType() {
        System.out.println("## 신용카드는 1번 현금은 2번");
        return scanner.nextInt();
    }
}
