package utils;

import java.util.*;

import domain.*;

/**
 * 사용자 입력으로 예외 값이 들어온 경우 처리하는 클래스
 */
public class InputException {
    private static List<Movie> movies = MovieRepository.getMovies();

    public static boolean inputViewIdException(int userIn) {
        int ret = 0;
        for (Movie movie : movies) {
            ret += compareMovieId(userIn, movie);
        }
        if (ret == 1) {
            return true;
        }
        return false;
    }

    public static boolean inputViewTimeException(int userIn, int movieId) {
        int size = 0;
        for (Movie movie : movies) {
            size += compareMovieTime(movie, movieId);
        }
//        if (size == 0) {
//            System.out.println("Error");
//        }
        if (size >= userIn && userIn >= 1) {
            return true;
        }
        return false;
    }

    public static boolean inputViewHeadException(int userIn, int movieId, int movieTime) {
        Movie target = null;
        int head;
        int idx = 0;
        int cnt = 0;
        for (int i = 0; cnt < 1; ++i) {
            cnt = compareMovieHead(movies.get(i), movieId);
            idx = i;
        }
        target = movies.get(idx);
//        if (target == null) {
//            System.out.println("Error");
//        }
        head = target.getPlaySchedules().get(movieTime - 1).getCapacity();
        if (head < userIn) {
            return false;
        }
        return true;
    }

    private static int compareMovieId(int userIn, Movie movie) {
        if (userIn == movie.getId()) {
            return 1;
        }
        return 0;
    }

    private static int compareMovieTime(Movie movie, int movieId) {
        int size = 0;
        if (movie.getId() == movieId) {
            size = movie.getPlaySchedulesSize();
        }
        return size;
    }

    private static int compareMovieHead(Movie movie, int movieId) {
        if (movie.getId() == movieId) {
            return 1;
        }
        return 0;
    }
}
