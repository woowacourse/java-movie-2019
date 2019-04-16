package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieTime() {
        System.out.println("## 예약할 시간을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieCustomer() {
        System.out.println("## 예약할 인원을 선택하세요.");
        return scanner.nextInt();
    }

    public static boolean inputPayMovieYesOrNo() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1, 추가 예약을 진행하시려면 2");
        boolean yes = true;
        try {
            yes = isOneOrTwo(scanner.nextInt());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            inputPayMovieYesOrNo();
        }
        return yes;
    }

    private static boolean isOneOrTwo(int inputInt) {
        if (inputInt != 1 && inputInt != 2) {
            throw new IllegalArgumentException("1과 2만 입력 가능합니다.");
        }
        if (inputInt == 1) {
            return true;
        }
        return false;
    }

    public static int inputPointAmount() {
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력하세요");
        return scanner.nextInt();
    }

    public static boolean inputCardOrCash() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return isOneOrTwo(scanner.nextInt());
    }

}
