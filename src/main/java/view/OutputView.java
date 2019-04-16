package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(List<Movie> movies, int movieNum) {
        for (Movie movie : movies) {
            int mid = movie.getId();
            if (mid == movieNum) {
                System.out.println(movie);
            }
        }
    }
    public static void reservationInformation(List<Movie> movies, int movieNum) {
        for (Movie movie : movies) {
            int mid = movie.getId();
            if (mid == movieNum) {
                System.out.println(movie);
            }
        }
    }
}