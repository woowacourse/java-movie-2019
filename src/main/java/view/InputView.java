package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMovieId() {
        String scannedMovieId;
        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            scannedMovieId=SCANNER.nextLine();
        }
        while (!Validator.isNaturalNumber(scannedMovieId));
        return Integer.parseInt(scannedMovieId);
    }


}
