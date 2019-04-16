package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        String movieId = scanner.nextLine();

        if (checkValid(movieId)) {
            return inputMovieId();
        }

        return Integer.parseInt(movieId);
    }

    public static int inputMovieTime() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        String selectSchedule = scanner.nextLine();

        if (checkValid(selectSchedule)) {
            return inputMovieTime();
        }

        return Integer.parseInt(selectSchedule);
    }

    public static int inputPeopleNumber() {
        System.out.println("## 예약할 인원을 입력하세요.");
        String number = scanner.nextLine();

        if (checkValid(number)) {
            return inputPeopleNumber();
        }

        return Integer.parseInt(number);
    }

    private static boolean checkValid(String input) {
        return isEmpty(input) || checkContainsChar(input);
    }

    private static boolean checkContainsChar(String movieId) {
        String pattern = "^[0-9]*$";

        if (!Pattern.matches(pattern, movieId)) {
            System.err.println("문자가 입력되었습니다.");
            return true;
        }

        return false;
    }

    private static boolean isEmpty(String movieId) {
        if (movieId.isEmpty()) {
            System.err.println("아무것도 입력되지 않았습니다.");
            return true;
        }

        return false;
    }
}
