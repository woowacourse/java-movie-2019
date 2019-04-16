package view;

import domain.Payment;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputPlaySchedule() {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영시간이 1번)");
        return scanner.nextInt();
    }

    public static int inputPeopleNumber() {
        System.out.println("## 예약할 인원을 입력하세요");
        return scanner.nextInt();
    }

    public static boolean selectMoreReseve() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        int n = scanner.nextInt();
        if (n == 1) {
            return true;
        }
        if (n == 2) {
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
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0원 (현재 포인트: " + nowPoint + "점)");
        return scanner.nextInt();
    }
}
