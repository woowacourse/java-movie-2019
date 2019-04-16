package view;

import error.Validator;
import utils.PrintUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            String id = scanner.nextLine();
            Validator.checkAccuracyOfMovieId(id);
            return Integer.parseInt(id);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputMovieId();
        }
    }
}
