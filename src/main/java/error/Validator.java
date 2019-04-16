package error;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import error.customExceptions.NotIntegerException;

public class Validator {
    private static final int EXISTENCE = 1;

    public static void checkAccuracyOfMovieId(String id) {
        if (!isInteger(id)) {
            throw new NotIntegerException();
        }
        if (!isExistingMovieId(Integer.parseInt(id))) {
            throw new IllegalArgumentException("존재하는 영화 아이디가 아닙니다. 영화 시간표를 참고해 주세요.");
        }
    }

    public static void checkAccuracyOfPlayScheduleIdx(String playScheduleIdxInput, Movie movieToReserve) {
        if (!isInteger(playScheduleIdxInput)) {
            throw new NotIntegerException();
        }
        int playScheduleIdx = Integer.parseInt(playScheduleIdxInput);
        if (!containsPlayScheduleIdx(playScheduleIdx, movieToReserve)) {
            throw new IllegalArgumentException("잘못된 영화 시간표 번호입니다. 시간표의 번호는 1번부터입니다.");
        }
        PlaySchedule playSchedule = movieToReserve.getPlayScheduleByIdx(playScheduleIdx);
        checkAccurateReservation(playSchedule, movieToReserve);
    }

    private static boolean containsPlayScheduleIdx(int playScheduleIdx, Movie movieToReserve) {
        return movieToReserve.containsPlayScheduleIdx(playScheduleIdx);
    }

    private static void checkAccurateReservation(PlaySchedule playSchedule, Movie movieToReserve) {
        if (!playSchedule.isBefore()) {
            throw new IllegalArgumentException("영화 시작시간이 지났습니다. 다음 영화를 예매해 주세요.");
        }

        // 기존에 예약한 영화와 같은 영화인 경우

        // 기존에 예약한 영화 시간대와 1시간 이상 차이나는 경우

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
