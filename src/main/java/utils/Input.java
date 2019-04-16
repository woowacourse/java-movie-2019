package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import view.InputView;
import view.OutputView;
import domain.Movie;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int idInput() {
        try {
            int inputNum = InputView.inputMovieId();
            CheckException.checkInMovieNum(inputNum);
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotInMovieNum();
            return idInput();
        }
    }

    public static int timeInput(Movie movie) {
        try {
            int inputNum = InputView.inputMovieTime();
            CheckException.checkInMovieTime(movie, inputNum);
//            CheckException.checkInAvailableTime(movie, InputNum); 상영시간이 현재 지났는지
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotInMovieTime();
            return timeInput(movie);
        }
    }

    public static int peopleInput(Movie movie, int movieTime) {
        try {
            int inputNum = InputView.inputPeopleNum();
            CheckException.checkcheckCapacity(movie, inputNum, movieTime);
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            return peopleInput(movie, movieTime);
        }
    }

    public static int restartInput() {
        try {
            int inputNum = InputView.inputRestart();
            CheckException.checkZeroOne(inputNum);
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotZeroOne();
            return restartInput();
        }
    }

    public static int pointInput(int price) {
        try {
            int inputNum = InputView.inputPoint();
            CheckException.checkPointInPrice(inputNum, price);
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotNumber();
            return pointInput(price);
        }
    }

    public static int creditCashInput() {
        try {
            int inputNum = InputView.inputCredit();
            CheckException.checkZeroOne(inputNum);
            return inputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotZeroOne();
            return creditCashInput();
        }
    }
}
