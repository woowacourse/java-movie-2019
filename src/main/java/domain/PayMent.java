package domain;

import java.util.Scanner;

public class PayMent {
    private static final Scanner scanner = new Scanner(System.in);

    public static void pay(int totalMoney) {
        System.out.println("## 결제를 진행합니다");
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입니다");
        int point = getPoints();
        int carOrCash = getCardOrCash();


    }

    private static int getPoints() {
        int point = scanner.nextInt();
        while (point < 0) {
            System.out.println("!! 포인트는 0 이상입니다.");
            return getPoints();
        }
        return point;
    }

    private static int getCardOrCash() {
        int cardOrCash = scanner.nextInt();
        while (cardOrCash != 1 && cardOrCash != 2) {
            return cardOrCash;
        }
        return cardOrCash;
    }
}
