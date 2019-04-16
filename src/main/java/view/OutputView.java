package view;

import domain.Movie;
import domain.ReservedMovie;

import java.util.List;

public class OutputView {
    private static final String RESERVED_LIST = "예약 내역";
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovies(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservedMovies(List<ReservedMovie> reservedMovies) {
        System.out.println(RESERVED_LIST);
        for (ReservedMovie reservedMovie : reservedMovies
             ) {
            System.out.println(reservedMovie.toString());
            System.out.println();
        }
    }
}
