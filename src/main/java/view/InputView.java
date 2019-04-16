package view;

import domain.MovieRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        int movieId = 0;
        System.out.println("## 예약할 영화를 선택하세요.");
        movieId = scanner.nextInt();
        if(MovieRepository.getMovie(movieId) == null){
            System.out.println("## 영화 번호를 정확히 입력해주세요.");
            inputMovieId();
        }
        return movieId;
    }

    public static int inputScheduleNumber() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }
}
