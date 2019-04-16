package error;

import domain.Movie;
import domain.MovieRepository;
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

    public static void checkAccuracyOfPlayScheduleIdx(String playScheduleIdx, Movie movieToReserve) {
        if (!isInteger(playScheduleIdx)) {
            throw new NotIntegerException();
        }
        if (!containsPlayScheduleIdx(Integer.parseInt(playScheduleIdx), movieToReserve)) {
            throw new IllegalArgumentException("잘못된 영화 시간표 번호입니다. 시간표의 번호는 1번부터입니다.");
        }
    }

    private static boolean containsPlayScheduleIdx(int playScheduleIdx, Movie movieToReserve) {
        return movieToReserve.containsPlayScheduleIdx(playScheduleIdx - 1);
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
