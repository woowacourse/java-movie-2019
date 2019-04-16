package view;

import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            int movieId = scanner.nextInt();
            if (MovieRepository.getMovies(movieId).isEmpty()) {
                throw new Exception("상영 목록에 없는 영화입니다.");
            }
            return movieId;
        } catch (Exception e) {
            System.out.println("## 상영 목록에 없는 영화입니다.");
            return inputMovieId();
        }
    }

    public static int inputMovieTime() {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }

    public static int inputMovieViewer() {
        System.out.println("## 예약할 인원을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPayOrAdditionalReservation() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            int input = scanner.nextInt();
            if (input != 1 && input != 2) {
                throw new Exception("잘못된 번호");
            }
            return input;
        } catch (Exception e) {
            System.out.println("## 잘못누르셨습니다.");
            return inputPayOrAdditionalReservation();
        }
    }


}
