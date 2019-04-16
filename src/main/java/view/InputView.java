package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieStartDateTimeIdx() {
        System.out.println("## 예약할시간표를선택하세요.(첫번째상영시간이1번)");
        return scanner.nextInt();
    }

    public static int inputNumReserve() {
        System.out.println("## 예약할인원을입력하세요.");
        return scanner.nextInt();
    }
}
