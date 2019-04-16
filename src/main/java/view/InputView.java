package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputMovieId();
        }
    }

    public static int inputPlaySchedule() {
        try {
            System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputMovieId();
        }
    }

    public static int inputCapacity() {
        try {
            System.out.println("##예약할인원을입력하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputMovieId();
        }
    }

    public static int inputContinueReservation() {
        try {
            System.out.println("##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return inputMovieId();
        }
    }
}
