package view;

import domain.Movie;
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

    public static int inputMovieTime(int movieId) {
        Movie movie = MovieRepository.getMovieForMovieId(movieId);
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        int movieTime = scanner.nextInt();
        if (!movie.matchMovieTime(movieTime)) {
            System.out.println("시간표를 다시 확인 해주세요");
            return inputMovieTime(movieId);
        }
        return movieTime;
    }

}
