package domain;

import java.util.Scanner;

public class PayMent {
    private static final Scanner scanner = new Scanner(System.in);
    private static final double[] DC_RATE = {0.05, 0.02};


    public static void pay(int totalMoney) {
        System.out.println("할인전금액 : " + totalMoney);
        System.out.println("## 결제를 진행합니다");
        int point = getPoints();
        int carOrCash = getCardOrCash();

        System.out.print("최종 결제 금액은 ");
        System.out.print(Math.ceil((totalMoney - point) * (1 - DC_RATE[carOrCash - 1])));
        System.out.println("입니다.\n" + "즐거운 관람 되세요.");
    }

    private static int getPoints() {
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입니다");
        int point = scanner.nextInt();
        while (point < 0) {
            System.out.println("!! 포인트는 0 이상입니다.");
            return getPoints();
        }
        return point;
    }

    private static int getCardOrCash() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int cardOrCash = scanner.nextInt();
        while (cardOrCash != 1 && cardOrCash != 2) {
            System.out.println("!! 1혹은 2를 입력해주세요.");
            return cardOrCash;
        }
        return cardOrCash;
    }
}
