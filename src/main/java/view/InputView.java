package view;

import domain.Movie;
import domain.ReservedMovie;
import input.*;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_MOVIE_ID = "## 예약할 영화를 선택하세요.";
    private static final String MOVIE_ID_ERROR = "## 영화 리스트에서 존재하는 영화의 ID를 고르셔야" +
            " 합니다.";
    private static final String ASK_SCHEDULE_ID = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String SCHEDULE_ID_ERROR = "현재 상영하는 스케줄 가운데서 골라 몇 번째 스케줄인지" +
            " 정수로 입력하셔야 합니다.";
    private static final String ASK_MEMBER_NUMBER = "## 예약할 인원을 입력하세요.";
    private static final String MEMBER_NUMBER_ERROR = "## 잔여좌석 이하, 0 이상인 정수로 입력하셔야" +
            " 합니다.";
    private static final String ASK_CONTINUE_OR_NOT = "## 예약을 종료하고 결제를 진행하려면 1번, " +
            "추가 예약을 진행하려면 2번";
    private static final String CONTINUE_ERROR = "## 1 또는 2인 정수를 입력하셔야 됩니다.";
    private static final String ASK_POINT = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String POINT_ERROR = "## 구매 금액 이하, 0 이상의 정수를 입력해야 합니다.";
    private static final String ASK_PURCHASE_METHOD = "## 신용카드는 1번, 현금은 2번";
    private static final String PURCHASE_METHOD_ERROR= "1 혹은 2인 정수를 입력해야 합니다.";



    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovie(List<Movie> movies) {
        System.out.println(ASK_MOVIE_ID);
        try {
            MovieInput movieInput = new MovieInput(movies, scanner.nextLine().trim());
            return movieInput.toMovie();
        } catch (Exception e) {
            System.out.println(MOVIE_ID_ERROR);
            return inputMovie(movies);
        }
    }

    public static int getScheduleId(Movie movie, List<ReservedMovie> reservedMovies) {
        System.out.println(ASK_SCHEDULE_ID);
        try {
            ScheduleInput scheduleInput = new ScheduleInput(movie,
                    scanner.nextLine().trim(), reservedMovies);
            return scheduleInput.scheduleIdIs();
        } catch (Exception e) {
            System.out.println(SCHEDULE_ID_ERROR);
            return getScheduleId(movie, reservedMovies);
        }
    }

    public static int getMemberNumber(Movie movie, int scheduleId) {
        System.out.println(ASK_MEMBER_NUMBER);
        try {
            MemberNumberInput memberNumberInput = new MemberNumberInput(movie, scheduleId,
                    scanner.nextLine().trim());
            return memberNumberInput.toMemberNumber();
        } catch (Exception e) {
            System.out.println(MEMBER_NUMBER_ERROR);
            return getMemberNumber(movie, scheduleId);
        }
    }

    public static Continue askContinuePurchaseOrNot() {
        System.out.println(ASK_CONTINUE_OR_NOT);
        try {
            Continue preference = Continue.valueOfInput(scanner.nextLine().trim());
            return preference;
        } catch (Exception e) {
            System.out.println(CONTINUE_ERROR);
            return askContinuePurchaseOrNot();
        }
    }

    public static int getPoint(List<ReservedMovie> reservedMovies) {
        System.out.println(ASK_POINT);
        try {
            Point point = new Point(scanner.nextLine().trim(),reservedMovies);
            return point.numberIs();
        } catch (Exception e) {
            System.out.println(POINT_ERROR);
            return getPoint(reservedMovies);
        }
    }

    public static double getDiscountRate() {
        System.out.println(ASK_PURCHASE_METHOD);
        try {
            PurchaseMethod purchaseMethod = PurchaseMethod.getValueOf(scanner.nextLine().trim());
            return purchaseMethod.showDiscountRate();
        } catch (Exception e) {
            System.out.println(PURCHASE_METHOD_ERROR);
            return getDiscountRate();
        }
    }

}
