package view;

import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservations(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }
}
