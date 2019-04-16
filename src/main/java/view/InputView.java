package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_TIME_MENT = "## 예약할 시간표를 선택하세요.(첫번째 사영 시간이 1번)";
    private static final String INPUT_ERROR_MENT = "입력 형식이 올바르지 않습니다.";

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieTime() {
        try {
            System.out.println(INPUT_MOVIE_TIME_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }
}
