package view;

import domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieSchedule(List<Movie> movies, int movieId) {
        //movies 에서 movieId 에 해당하는 것을 출력
        for (Movie movie : movies) {
            printSchedule(movie, movieId);
        }
    }

    private static void printSchedule(Movie movie, int movieId) {
        if (movieId == movie.getId()) {
            System.out.println(movie);
        }
    }
}
