package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int InputPaymentOrBuyMessage() {
        System.out.println("##예약을종료하고결제를진행하려면1번,추가예약을진행하려면2번");
        return scanner.nextInt();
    }

    public static int inputGetPoint() {
        System.out.println("##결제를진행합니다.\n" +
            "##포인트사용금액을입력하세요.포인트가없으면0입력");
        return scanner.nextInt();
    }

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieSchedule() {
        System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
        return scanner.nextInt();
    }

    public static int inputPeopleCount() {
        System.out.println("##예약할인원을입력하세요.");
        return scanner.nextInt();
    }

    public static int inputSelectCashOrCard() {
        System.out.println("##신용카드는1번,현금은2번");

        return scanner.nextInt();
    }
}
