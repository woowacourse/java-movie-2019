package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie printMovieSchedule(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                System.out.println(movie);
                return movie;
            }
        }

        return null;
    }
}
