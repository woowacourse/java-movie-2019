package error;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import error.customExceptions.NonAccurateSelection;
import error.customExceptions.NotIntegerException;
import view.InputView;

public class Validator {
    private static final int EXISTENCE = 1;

    public static void checkAccuracyOfMovieId(String id) {
        checkInteger(id);
        if (!isExistingMovieId(Integer.parseInt(id))) {
            throw new IllegalArgumentException("존재하는 영화 아이디가 아닙니다. 영화 시간표를 참고해 주세요.");
        }
        // 영화의 모든 시작 시간이 지난 시간일 경우
    }

    public static void checkAccuracyOfPlayScheduleIdx(String playScheduleIdxInput, Movie movieToReserve) {
        checkInteger(playScheduleIdxInput);
        int playScheduleIdx = Integer.parseInt(playScheduleIdxInput);
        if (!containsPlayScheduleIdx(playScheduleIdx, movieToReserve)) {
            throw new IllegalArgumentException("잘못된 영화 시간표 번호입니다. 시간표의 번호는 1번부터입니다.");
        }
        PlaySchedule playSchedule = movieToReserve.getPlayScheduleByIdx(playScheduleIdx);
        checkAccurateReservation(playSchedule, movieToReserve);
    }

    private static void checkAccurateReservation(PlaySchedule playSchedule, Movie movieToReserve) {
        if (!playSchedule.isBefore()) {
            throw new IllegalArgumentException("영화 시작시간이 지났습니다. 다음 영화를 예매해 주세요.");
        }

        // 기존에 예약한 영화와 같은 영화인 경우

        // 기존에 예약한 영화 시간대와 1시간 이상 차이나는 경우

    }

    public static void checkAccuracyOfPeopleToReserve(String peopleToReserveInput, PlaySchedule playSchedule) {
        checkInteger(peopleToReserveInput);
        int peopleToReserve = Integer.parseInt(peopleToReserveInput);
        if (!isCapacious(peopleToReserve, playSchedule)) {
            throw new IllegalArgumentException("올바른 예약 가능 인원수가 아닙니다. 영화 정보를 다시 확인해 주세요.");
        }
    }

    public static void checkAccuracyOfPaymentDecision(String paymentDecisionInput) {
        checkInteger(paymentDecisionInput);
        int paymentDecision = Integer.parseInt(paymentDecisionInput);
        checkAccurateSelection(paymentDecision);
    }

    public static void checkAccuracyOfMoviePoint(String moviePointInput) {
        checkInteger(moviePointInput);
    }

    public static void checkAccuracyOfPaymentMethodDecision(String paymentMethodDecisionInput) {
        checkInteger(paymentMethodDecisionInput);
        int paymentMethodDecision = Integer.parseInt(paymentMethodDecisionInput);
        checkAccurateSelection(paymentMethodDecision);
    }

    private static void checkAccurateSelection(int input) {
        if ((input != InputView.FIRST_SELECTION) && (input != InputView.SECOND_SELECTION)) {
            throw new NonAccurateSelection();
        }
    }

    private static boolean containsPlayScheduleIdx(int playScheduleIdx, Movie movieToReserve) {
        return movieToReserve.containsPlayScheduleIdx(playScheduleIdx);
    }

    private static boolean isCapacious(int peopleToReserve, PlaySchedule playSchedule) {
        return playSchedule.isCapacious(peopleToReserve);
    }

    private static void checkInteger(String input) {
        if (!isInteger(input)) {
            throw new NotIntegerException();
        }
    }

    private static boolean isInteger(String id) {
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isExistingMovieId(int id) {
        return (MovieRepository.getMovies().stream().filter(movie->movie.isSameId(id)).toArray().length == EXISTENCE);
    }
}
