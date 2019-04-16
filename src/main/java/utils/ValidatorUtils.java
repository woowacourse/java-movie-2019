package utils;

import domain.MovieRepository;

public class ValidatorUtils {

    public static boolean isNaturalMovieId(int movieId) {
        if (!MovieRepository.containsMovieId(movieId)) {
            System.out.println("상영목록에 없는 영화를 선택했습니다.");
            return false;
        }

        return true;
    }

    public static boolean isNaturalScheduleNumber(int movieId, int scheduleNumber) {
        if (!MovieRepository.containsSchedule(movieId, scheduleNumber)) {
            System.out.println("없는 시간표 입니다.");
            return false;
        }

        return true;
    }

}
