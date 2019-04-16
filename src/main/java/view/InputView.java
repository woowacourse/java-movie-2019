package view;

import java.util.Scanner;

public class InputView {
    private static final String MOVIE_GUIDE = "## 예약할 영화를 선택하세요.";
    private static final String SCHEDULE_GUIDE = "## 예약할 시간표를 선택하세요."
        + "(첫번째 상영 시간이 1번)";
    private static final String HEADCOUNT_GUIDE = "## 예약할 인원을 입력하세요.";
    private static final String CONTINUE_GUIDE = "## 예약을 종료하고 결제를 진행하려면 "
        + "1번, 추가 예약을 진행하려면 2번";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println(MOVIE_GUIDE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputMovieId();
        }
    }

    public static int inputMovieSchedule() {
        System.out.println(SCHEDULE_GUIDE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputMovieSchedule();
        }
    }

    public static int inputHeadcount() {
        System.out.println(HEADCOUNT_GUIDE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputHeadcount();
        }
    }

    public static int inputContinueOrPay() {
        System.out.println(CONTINUE_GUIDE);
        try {
            int userInput = Integer.parseInt(scanner.nextLine());
            boolean isValid = Validator.validateUserInput(userInput);
            return (isValid) ? userInput : inputContinueOrPay();
        } catch (IllegalArgumentException e) {
            return inputContinueOrPay();
        }
    }
}
