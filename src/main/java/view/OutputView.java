package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            printMovie(movie, movieId);
        }
    }

    private static void printMovie(Movie movie, int movieId) {
        if (movie.isContainsMovieId(movieId)) {
            System.out.println(movie);
        }
    }
}
