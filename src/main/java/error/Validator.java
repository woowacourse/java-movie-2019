package error;

import domain.Movie;
import domain.MovieRepository;

public class Validator {

    private static final String WARNING_WHEN_NOT_INTEGER = "정수가 아닙니다";
    private static final String WARNING_WHEN_MOVIE_NOT_EXIST = "해당 영화는 존재하지 않습니다";
    private static final String WARNING_WHEN_MOVIE_DONT_HAVE_VACANCY = "해당 영화는 공석이 존재하지 않습니다.";

    // 정수인지
    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_NOT_INTEGER);
            return false;
        }
    }

    // 무비가 존재하는지
    public static boolean isMovieExist(int movieNumber) {
        if (MovieRepository.isMovieExist(movieNumber)) {
            return true;
        }
        System.out.println(WARNING_WHEN_MOVIE_NOT_EXIST);
        return false;
    }

    // 그무비가 공석이 있는지
    public static boolean isMovieHasVacancy(Movie movie) {
        if (movie.vacancyExist()) {
            return true;
        }
        System.out.println(WARNING_WHEN_MOVIE_DONT_HAVE_VACANCY);
        return false;
    }
}
