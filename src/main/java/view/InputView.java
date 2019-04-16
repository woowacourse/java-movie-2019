package view;

import domain.Payment;

import java.util.Scanner;

public class InputView {
    private final static int GO_PAYMENT = 1;
    private final static int CONTINUE_RESERVE = 2;

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return getInputSingleInteger();
    }

    public static int inputPlaySchedule() {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영시간이 1번)");
        return getInputSingleInteger();
    }

    public static int inputPeopleNumber() {
        System.out.println("## 예약할 인원을 입력하세요");
        return getInputSingleInteger();
    }

    public static boolean selectMoreReserve() {
        System.out.println(String.format("## 예약을 종료하고 결제를 진행하려면 %d번, 추가 예약을 진행하려면 %d번", GO_PAYMENT, CONTINUE_RESERVE));
        int n = getInputSingleInteger();

        if (n == CONTINUE_RESERVE) {
            return true;
        }
        if (n == GO_PAYMENT) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static Payment selectPaymentMethod() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int n = scanner.nextInt();
        if (n == 1) {
            return Payment.CARD;
        }
        if (n == 2) {
            return Payment.CASH;
        }
        throw new IllegalArgumentException();
    }

    public static int inputPoint(int nowPoint) {
        System.out.println("## 결제를 진행합니다.");
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0원 (현재 포인트: " + nowPoint + "점)");
        return scanner.nextInt();
    }

    private static int getInputSingleInteger() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (java.lang.NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }
}
