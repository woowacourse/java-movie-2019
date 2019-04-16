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

    public static int inputMovieCapacity(int movieId, int movieTime) {
        Movie movie = MovieRepository.getMovieForMovieId(movieId);
        System.out.println("## 예약할 인원을 입력하세요.");
        int capacity = scanner.nextInt();
        if(!movie.matchMovieCapacity(movieTime, capacity)) {
            return inputMovieCapacity(movieId, movieTime);
        }
        return capacity;
    }

    public static boolean inputRestart() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        int flag = scanner.nextInt();
        if (flag == 1) {
            return false;
        }
        if (flag == 2) {
            return true;
        }
        return inputRestart();
    }

    public static int inputPoint() {
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        int point = scanner.nextInt();
        if (point < 0) {
            return inputPoint();
        }
        return point;
    }

    public static int inputSelectPayWith() {
        System.out.println("## 신용카드는 1번,현금은 2번");
        int payWith = scanner.nextInt();
        if (payWith == 1 || payWith == 2) {
            return payWith;
        }
        return inputSelectPayWith();
    }


}
