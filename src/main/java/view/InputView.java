package view;

import domain.Movie;
import domain.MoviePoint;
import domain.PlaySchedule;
import error.Validator;
import utils.PrintUtils;

import java.util.Scanner;

public class InputView {
    public static final int FIRST_SELECTION = 1;
    public static final int SECOND_SELECTION = 2;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            String id = scanner.nextLine();
            Validator.checkAccuracyOfMovieId(id);
            return Integer.parseInt(id);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputMovieId();
        }
    }

    public static PlaySchedule inputPlaySchedule(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫 번째 상영 시간이 1번)");
        try {
            String playScheduleIdx = scanner.nextLine();
            Validator.checkAccuracyOfPlayScheduleIdx(playScheduleIdx, movie);
            return movie.getPlayScheduleByIdx(Integer.parseInt(playScheduleIdx));
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputPlaySchedule(movie);
        }
    }

    public static int inputPeopleToReserve(PlaySchedule playSchedule) {
        System.out.println("## 예약할 인원을 입력하세요.");
        try {
            String peopleToReserve = scanner.nextLine();
            Validator.checkAccuracyOfPeopleToReserve(peopleToReserve, playSchedule);
            return Integer.parseInt(peopleToReserve);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputPeopleToReserve(playSchedule);
        }
    }

    public static int inputPaymentDecision() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        try {
            String paymentDecision = scanner.nextLine();
            Validator.checkAccuracyOfPaymentDecision(paymentDecision);
            return Integer.parseInt(paymentDecision);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputPaymentDecision();
        }
    }

    public static void guideForPayment() {
        System.out.print("## 결제를 진행합니다.");
        PrintUtils.pause();
    }

    public static MoviePoint inputMoviePoint() {
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        try {
            String moviePoint = scanner.nextLine();
            Validator.checkAccuracyOfMoviePoint(moviePoint);
            return new MoviePoint(Integer.parseInt(moviePoint));
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputMoviePoint();
        }
    }

    public static int inputPaymentMethodDecision() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        try {
            String paymentMethodDecision = scanner.nextLine();
            Validator.checkAccuracyOfPaymentMethodDecision(paymentMethodDecision);
            return Integer.parseInt(paymentMethodDecision);
        } catch (IllegalArgumentException e) {
            PrintUtils.printErrorMessageWithPause(e);
            return inputPaymentMethodDecision();
        }
    }
}
