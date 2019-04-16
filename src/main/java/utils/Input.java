package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import view.InputView;
import view.OutputView;
import domain.Movie;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int idInput(){
        try{
            int InputNum = InputView.inputMovieId();
            CheckException.checkInMovieNum(InputNum);
            return InputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotInMovieNum();
            return idInput();
        }
    }

    public static int timeInput(Movie movie){
        try{
            int InputNum = InputView.inputMovieTime();
            CheckException.checkInMovieTime(movie, InputNum);
//            CheckException.checkInAvailableTime(movie, InputNum); 상영시간이 현재 지났는지
            return InputNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            OutputView.printNotInMovieTime();
            return timeInput(movie);
        }
    }
}
