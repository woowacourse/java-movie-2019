package view;

import domain.Movie;
import domain.PlaySchedule;
import error.Validator;
import utils.PrintUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            String id = scanner.nextLine();
            Validator.checkAccuracyOfMovieId(id);
            return Integer.parseInt(id);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputMovieId();
        }
    }

    public static PlaySchedule inputPlaySchedule(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫 번째 상영 시간이 1번)");
        try {
            String playScheduleIdx = scanner.nextLine();
            Validator.checkAccuracyOfPlayScheduleIdx(playScheduleIdx, movie);
            return movie.getPlayScheduleByIdx(Integer.parseInt(playScheduleIdx) - 1);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputPlaySchedule(movie);
        }
    }
}
