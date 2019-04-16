package view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_MOVIE_ID = "## 예약할 영화를 선택하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println(ASK_MOVIE_ID);
        return scanner.nextInt();
    }
}
