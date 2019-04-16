package utils;

import java.util.*;

import domain.*;

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
        if (size == 0) {
            System.out.println("Error");
        }
        System.out.println("Size: " + size);
        if (size >= userIn && userIn >= 1) {
            return true;
        }
        return false;
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
}
