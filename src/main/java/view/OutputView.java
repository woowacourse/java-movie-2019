package view;

import domain.Movie;
import domain.BookedMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMoviesByID(List<Movie> movies, int id) {
        for (Movie movie : movies) {
            if (movie.getID() == id) System.out.println(movie);
        }
    }

    public static void printBookedMovies(List<BookedMovie> movies) {
        for (BookedMovie movie : movies) {
            System.out.println(movie);
        }
    }
}
