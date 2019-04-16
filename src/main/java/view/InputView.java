package view;

import domain.MovieConstants;
import domain.PlaySchedule;

import java.util.Scanner;

public class InputView extends MovieConstants {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");

        int moviedID = scanner.nextInt();

        if(moviedID < 1 && moviedID > COUNT_OF_MOVIES) {
            System.out.println("없는 영화 입니다.");
            return inputMovieId();
        }

        return moviedID;
    }

    public static PlaySchedule inputMovieSchedule() {

        return null;
    }
}
