package Exceptions;

import view.InputView;
import view.OutputView;

public class IdException {

    public static int inputMovieId(int number) {
        if (number != 1 && number != 5 && number != 7 && number != 8) {
            OutputView.printIdException();
            return InputView.inputMovieId();
        }
        return number;
    }
}
