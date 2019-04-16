package view;

import utils.ValidatorUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        int movieId;

        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            movieId = scanner.nextInt();
        } while (!ValidatorUtils.isNaturalMovieId(movieId));

        return movieId;
    }

    public static int inputScheduleNumber() {
        System.out.println("## 예약할 시간표를 선택하세요.");

        return scanner.nextInt();
    }

    public static int inputReservationCount() {
        System.out.println("## 예약할 인원을 입력하세요.");

        return scanner.nextInt();
    }
}
