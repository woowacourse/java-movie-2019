package domain;

import view.InputView;

import java.util.Iterator;
import java.util.List;

/**
 * 영화 예매 시스템 사용자 역할을 하는 클래스
 */
public class User {
    public static int selectMovie() {
        return InputView.inputMovieId();
    }

    public static int selectSchedule(int movieId) {
        return InputView.inputScheduleId(movieId);
    }

    public static int selectPersonnels(int movieId, int scheduleId) { return InputView.inputPersonnels(movieId, scheduleId); }

    public static boolean isEndReservation() { return (InputView.inputContinue() == 1) ? true : false; }

    public static int selectPointUse() { return InputView.inputPoint(); }
}
