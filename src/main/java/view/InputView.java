package view;

import domain.Movie;
import domain.PlaySchedule;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * 예약할 영화를 선택
     */
    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    /*
     * 예약할 영화의 시간을 선택
     */
    public static int inputMovieSchedule(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }


}
