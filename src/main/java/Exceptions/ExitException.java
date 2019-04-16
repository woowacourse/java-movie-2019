package Exceptions;

import view.InputView;
import view.OutputView;

public class ExitException {

    public static int inputMovieExit(int number) {
        if(number != 1 && number != 2){
            OutputView.printExitException();
            return InputView.inputMovieExit();
        }
        return number;
    }
}
