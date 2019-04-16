package view;

import reservation.MovieReservation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return MovieReservation.checkExistList(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputMovieId();
        }
    }
}
