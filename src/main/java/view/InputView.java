package view;

import domain.MovieRepository;
import domain.Movie;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();

        if (MovieRepository.isValidId(movieId)) {
            return movieId;
        }

        return inputMovieId();
    }

    public static int inputScheduleId(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영시간이 1번)");
        int scheduleId = scanner.nextInt();

        if (movie.isValidScheduleId(scheduleId)) {
            return scheduleId;
        }

        return inputScheduleId(movie);
    }

}
