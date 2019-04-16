package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovies(List<Movie> movies, int movieId) {
        System.out.println(movies.get(movieId));
    }
}
