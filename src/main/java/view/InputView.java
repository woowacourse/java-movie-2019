package view;

import domain.Movie;
import domain.PlaySchedule;
import reservation.MovieReservation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return MovieReservation.checkExistList(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputMovieId();
        }
    }

    public static PlaySchedule inputPlaySchedule(Movie selectedMovie) {
        try {
            System.out.println("예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
            return MovieReservation.checkExistSchedule(selectedMovie,
                    Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputPlaySchedule(selectedMovie);
        }
    }
}
