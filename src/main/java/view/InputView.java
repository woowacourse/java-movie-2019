package view;

import domain.MovieId;
import domain.NumberOfPeople;
import domain.ScheduleNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static MovieId inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return new MovieId(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return inputMovieId();
        } catch (IllegalArgumentException e) {
            return inputMovieId();
        }
    }

    public static ScheduleNumber inputScheduleNumberOf(int movieId) {
        try {
            System.out.println("## 예약할 시간표를 선택세요 (첫 번째 상영 시간이 1번)");
            return new ScheduleNumber(movieId, Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return inputScheduleNumberOf(movieId);
        } catch (IllegalArgumentException e) {
            return inputScheduleNumberOf(movieId);
        }
    }

    public static NumberOfPeople inputNumberOfPeople() {
        return null;
    }
}
