package view;

import domain.Movie;
import domain.ReservedMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovies(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservedMovies(List<ReservedMovie> reservedMovies) {
        for (ReservedMovie reservedMovie : reservedMovies
             ) {
            System.out.println(reservedMovie);
            System.out.println();
        }
    }
}
