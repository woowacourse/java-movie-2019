package view;

import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();
        if (MovieRepository.getMovieForMovieId(movieId) == null) {
            System.out.println("영화 목록에 없습니다.");
            return inputMovieId();
        }
        return movieId;
    }

}
