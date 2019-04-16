package Exceptions;

import view.InputView;
import view.OutputView;

public class PointException {
    public static int inputPoint(int point) {
        if (point < 0) {
            OutputView.printPointException();
            return InputView.inputPoint();
        }
        return point;
    }
}
