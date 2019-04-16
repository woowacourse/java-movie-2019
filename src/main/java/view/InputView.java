package view;

import utils.InputException;

import java.util.Scanner;

/**
 * 사용자 콘솔 입력 클래스
 */
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        int userIn;
        System.out.println("## 예약할 영화를 선택하세요.");
        userIn = scanner.nextInt();
        if (!InputException.inputViewIdException(userIn)) {
            System.out.println("다시 입력하세요.");
            return inputMovieId();
        }
        return userIn;
    }

    public static int inputMovieTime(int movieId) {
        int userIn;
        System.out.println("## 예약할 시간표를 선택하세요.(첫 번째 상영 시간이 1번)");
        userIn = scanner.nextInt();
        if(!InputException.inputViewTimeException(userIn, movieId)) {
            System.out.println("다시 입력하세요.");
            return inputMovieTime(movieId);
        }
        return userIn;
    }

    public static int inputMovieHead(int movieId, int movieTime) {
        int userIn;
        System.out.println("## 예약할 인원을 입력하세요.");
        userIn = scanner.nextInt();
        if(!InputException.inputViewHeadException(userIn, movieId, movieTime)) {
            System.out.println("다시 입력하세요.");
            return inputMovieHead(movieId, movieTime);
        }
        return userIn;
    }
}
