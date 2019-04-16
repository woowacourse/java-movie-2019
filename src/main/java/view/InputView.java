package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return Integer.parseInt(scan.nextLine().trim());
    }
}
