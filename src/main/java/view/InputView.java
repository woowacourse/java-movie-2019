package view;

import domain.Movie;
import error.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        String userInput = scanner.nextLine().trim();
        if (!Validator.isInteger(userInput)) {
            return inputMovieId();
        }
        int movieNumber = Integer.parseInt(userInput);
        if (!Validator.isMovieExist(movieNumber) ||
                !Validator.isMovieHasVacancy(movieNumber)) {
            return inputMovieId();
        }
        return movieNumber;
    }

}
