package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int inputMovieScheduleId() {
        try {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieScheduleId();
        }
    }
}
