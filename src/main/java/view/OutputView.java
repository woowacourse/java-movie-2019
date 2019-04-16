package view;

import domain.Movie;
import domain.MovieReservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservations(List<MovieReservation> reservations) {
        System.out.println("예약 내역");

        for (MovieReservation reservation : reservations) {
            System.out.println(reservation + "\n");
        }
    }
}
