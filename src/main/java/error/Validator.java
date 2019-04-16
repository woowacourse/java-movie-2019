package error;

import domain.Movie;
import domain.MovieRepository;
import utils.MovieDataRequester;

import java.util.List;

public class Validator {

    private static final String WARNING_WHEN_NOT_INTEGER = "정수가 아닙니다";
    private static final String WARNING_WHEN_MOVIE_NOT_EXIST = "해당 영화는 존재하지 않습니다";
    private static final String WARNING_WHEN_MOVIE_DONT_HAVE_VACANCY = "해당 영화는 공석이 존재하지 않습니다.";
    private static final String WARNING_WHEN_SCHEDULE_NOT_EXIST = "해당 스캐줄은 존재하지 않습니다.";
    private static final String WARNING_WHEN_SCHEDULE_DONT_HAVE_VACANCY = "해당 스캐줄은 공석이 존재하지 않습니다.";
    private static final String WARNING_WHEN_SCHEDULE_DONT_HAVE_ENOUGH_PLACE = "인원 초과 입니다.";

    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_NOT_INTEGER);
            return false;
        }
    }

    public static boolean isMovieExist(int movieNumber) {
        if (MovieRepository.isMovieExist(movieNumber)) {
            return true;
        }
        System.out.println(WARNING_WHEN_MOVIE_NOT_EXIST);
        return false;
    }

    public static boolean isMovieHasVacancy(int movieNumber) {
        Movie movie = MovieDataRequester.getMovie(movieNumber);
        if (movie.vacancyExist()) {
            return true;
        }
        System.out.println(WARNING_WHEN_MOVIE_DONT_HAVE_VACANCY);
        return false;
    }

    public static boolean isScheduleExist(int movieNumber, int scheduleIndex) {
        if (!isMovieExist(movieNumber)) {
            return false;
        }
        boolean isScheduleExist = MovieDataRequester.getMovie(movieNumber).isScheduleExist(scheduleIndex);
        if (!isScheduleExist) {
            System.out.println(WARNING_WHEN_SCHEDULE_NOT_EXIST);
            return false;
        }
        return true;
    }

    public static boolean isScheduleHaveVacancy(int movieNumber, int scheduleIndex) {
        if (!isMovieExist(movieNumber)) {
            return false;
        }
        boolean isScheduleHaveVacncy = MovieDataRequester.getMovie(movieNumber).getSchedule(scheduleIndex).isNotEmpty();
        if (!isScheduleHaveVacncy) {
            System.out.println(WARNING_WHEN_SCHEDULE_DONT_HAVE_VACANCY);
            return false;
        }
        return true;
    }

    public static boolean isScheduleReservePossible(int movieNumber, int scheduleIndex, int personCount) {
        boolean reservePossible = MovieDataRequester
                .getMovie(movieNumber)
                .getSchedule(scheduleIndex)
                .isReservePossible(personCount);
        if (!reservePossible) {
            System.out.println(WARNING_WHEN_SCHEDULE_DONT_HAVE_ENOUGH_PLACE);
            return false;
        }
        return true;
    }

}
