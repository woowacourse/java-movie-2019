package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int intInput(){
        try{
            int InputNum = InputView.inputMovieId();
            CheckException.checkInMovieNum(InputNum);
            return InputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotInMovieNum();
            return intInput();
        }
    }
}
