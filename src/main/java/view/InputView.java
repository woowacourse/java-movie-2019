package view;

import domain.Movie;
import input.MemberNumberInput;
import input.MovieInput;
import input.ScheduleInput;

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

    public static int getScheduleId(Movie movie) {
        System.out.println(ASK_SCHEDULE_ID);
        try {
            ScheduleInput scheduleInput = new ScheduleInput(movie, scanner.nextLine().trim());
            return scheduleInput.scheduleIdIs();
        } catch (Exception e) {
            System.out.println(SCHEDULE_ID_ERROR);
            return getScheduleId(movie);
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
}
