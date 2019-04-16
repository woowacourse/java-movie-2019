package Exceptions;

import view.InputView;
import view.OutputView;

public class TimeException {

    public static int inputMovieTime(int number, int size) {
        if(number <= 0 || number > size){
            OutputView.printTImeException();
            return InputView.inputMovieTime(size);
        }
        return number;
    }
}
