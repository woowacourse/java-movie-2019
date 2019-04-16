package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PAYMENT_TYPE_MESSAGE = "## 신용카드는 1번, 현금은 2번";
    private static final String POINT_MESSAGE = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String INPUT_ONE_NUMBER_ERROR_MESSAGE = "한가지의 숫자만 입력해주세요.";
    private static final String RESERVATION_MESSAGE = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String INPUT_SELECT_MOVIE_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String PATTERN = "^[0-9]*$";
    private static final String INPUT_SCHEDULE_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String INPUT_CAPACITY_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String INPUT_NOT_INTEGER_ERROR_MESSAGE = "문자가 입력되었습니다.";
    private static final String IS_EMPTY_ERROR_MESSAGE = "아무것도 입력되지 않았습니다.";
    private static final String INPUT_ZERO_ERROR_MESSAGE = "0은 입력될 수 없습니다.";
    private static final int ONE = 1;

    public static int inputPaymentType() {
        System.out.println(PAYMENT_TYPE_MESSAGE);
        String paymentType = scanner.nextLine();

        if (checkValid(paymentType) || inZero(paymentType)) {
            return inputPaymentType();
        }

        return Integer.parseInt(paymentType);
    }

    public static int inputPoint() {
        System.out.println(POINT_MESSAGE);
        String point = scanner.nextLine();

        if (checkValid(point)) {
            return inputPoint();
        }

        return Integer.parseInt(point);
    }

    public static boolean checkInputMore(String input) {
        if (input.length() != ONE) {
            System.err.println(INPUT_ONE_NUMBER_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    public static int inputSelectNext() {
        System.out.println(RESERVATION_MESSAGE);
        String select = scanner.nextLine();

        if (checkValid(select) || inZero(select) || checkInputMore(select)) {
            return inputSelectNext();
        }

        return Integer.parseInt(select);
    }

    public static int inputMovieId() {
        System.out.println(INPUT_SELECT_MOVIE_MESSAGE);
        String movieId = scanner.nextLine();

        if (checkValid(movieId) || inZero(movieId)) {
            return inputMovieId();
        }

        return Integer.parseInt(movieId);
    }

    public static int inputMovieTime() {
        System.out.println(INPUT_SCHEDULE_MESSAGE);
        String selectSchedule = scanner.nextLine();

        if (checkValid(selectSchedule) || inZero(selectSchedule)) {
            return inputMovieTime();
        }

        return Integer.parseInt(selectSchedule);
    }

    public static int inputPeopleNumber() {
        System.out.println(INPUT_CAPACITY_MESSAGE);
        String number = scanner.nextLine();

        if (checkValid(number) || inZero(number)) {
            return inputPeopleNumber();
        }

        return Integer.parseInt(number);
    }

    private static boolean checkValid(String input) {
        return isEmpty(input) || checkContainsChar(input);
    }

    private static boolean checkContainsChar(String input) {
        if (!Pattern.matches(PATTERN, input)) {
            System.err.println(INPUT_NOT_INTEGER_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private static boolean isEmpty(String input) {
        if (input.isEmpty()) {
            System.err.println(IS_EMPTY_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private static boolean inZero(String input) {
        if (Integer.parseInt(input) == 0) {
            System.err.println(INPUT_ZERO_ERROR_MESSAGE);
            return true;
        }

        return false;
    }
}
