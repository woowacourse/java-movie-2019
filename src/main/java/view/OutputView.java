package view;

import domain.Movie;
import domain.ReservingMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printDetailsOfReservingMovie(List<ReservingMovie> reservingMovies) {
        for(ReservingMovie reservingMovie : reservingMovies) {
            System.out.println(reservingMovie);
        }
    }
}
