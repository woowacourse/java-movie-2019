package view;

import domain.PlaySchedule;
import domain.Movie;
import java.util.Scanner;
import java.util.List;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int COUNT_OF_MOVIES = 8;
    private static final int COUNT_OF_SCHEDULES = 5;

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");

        int moviedID = scanner.nextInt();

        if (moviedID < 1 && moviedID > COUNT_OF_MOVIES) {
            System.out.println("!! 없는 영화 입니다.");
            return inputMovieId();
        }

        return moviedID;
    }

    public static PlaySchedule inputMovieSchedule(List<Movie> movies, int movieId) {
        System.out.println("## 예약할 인원을 입력하세요.");

        int scheduleNumber = scanner.nextInt();

        while (scheduleNumber < 1 && scheduleNumber > COUNT_OF_SCHEDULES) {
            System.out.println("!! 없는 스케쥴 입니다.");
            return inputMovieSchedule(movies, movieId);
        }

        PlaySchedule playSchedule = movies.get(movieId).getSchedule(scheduleNumber);
        return playSchedule;
    }
}
