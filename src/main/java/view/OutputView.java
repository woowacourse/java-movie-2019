package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void outputReservedMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            printReserveMovie(movie, movieId);
        }
    }

    private static void printReserveMovie(Movie movie, int movieId) {
        if (movie.isMatchMovie(movieId)) {
            System.out.println(movie);
        }
    }
}
