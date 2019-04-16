package utils;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class InputError {
    public static boolean handleMovieIdInputError(int movieId, List<Movie> movies) {
        if (movieId < 0 || !isContains(movieId, movies)) {
            System.out.println("<오류> 영화 목록에 없는 번호입니다.");
            return false;
        }
        return true;
    }

    public static boolean handleMovieStartTimeInputError(int movieStartTime, int movieId) {
        if (movieStartTime < 0 || !MovieRepository.getMovieUsingMovieID(movieId).isSmallerPlayScheduleSize(movieStartTime)) {
            System.out.println("<오류> 상영 시간에 없는 영화입니다.");
            return false;
        }

        return true;
    }

    private static boolean isContains(int movieID, List<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.isMatchMovieID(movieID))
                return true;
        }
        return false;
    }
}
