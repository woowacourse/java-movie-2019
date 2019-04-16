package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MOVIE_ID_MSG = "## 예약할 영화를 선택하세요.";

    private static final String ERROR_MSG_INPUT_MOVIE_ID = "숫자만 입력해주세요.";

    public static int inputMovieId() {
        try{
            System.out.println(INPUT_MOVIE_ID_MSG);
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_MOVIE_ID);
            scanner.next();
            return  inputMovieId();
        }
    }
}
