package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String SELECT_MOVIE_TO_RESERVE_MESSAGE = "## 예약할 영화를 선택하세요.";

    public static int inputMovieId() {
        System.out.println(SELECT_MOVIE_TO_RESERVE_MESSAGE);
        return scanner.nextInt();
    }
}
