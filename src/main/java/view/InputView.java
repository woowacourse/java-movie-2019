package view;

import java.util.Scanner;

import domain.Movie;
import domain.MovieRepository;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return MovieRepository.getMovieById(input);
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int inputMovieTime(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return movie.isValidTime(input);
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            return inputMovieTime(movie);
        }
    }

    public static int inputReserveCount(int id, Movie movie) {
        System.out.println("## 예약할 인원을 입력하세요");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return movie.isValidCapacity(id, input);
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            return inputReserveCount(id, movie);
        }
    }

    public static int inputChooseProcess() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            isInputOneOrTwoValid(input);
            return input;
        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
            return inputChooseProcess();
        }
    }

    private static boolean isInputOneOrTwoValid(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
        return true;
    }

    public static int inputPointAmount() {
        try {
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputPointAmount();
        }
    }

    public static int inputPayType() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        try {
            int input = Integer.parseInt(scanner.nextLine());
            isInputOneOrTwoValid(input);
            return input;
        } catch (IllegalArgumentException e) {
            return inputPayType();
        }
    }
}
