package view;

import validator.MovieInputValidator;
import validator.Validator;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private Validator validator;

    public InputView() {
        scanner = new Scanner(System.in);
        validator = null;
    }

    public int inputMovieId() {
        String input = null;
        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            input = scanner.nextLine();
            validator = new MovieInputValidator(input);
        } while(!validator.doesValid());

        return Integer.parseInt(input);
    }
}
