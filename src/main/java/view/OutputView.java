package view;

import domain.BookingList;
import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printBookingList(BookingList bookingList) {
        System.out.println("예약 내역");
        System.out.println(bookingList);
    }

    public static void printPlaySchedule(Movie selectedMovie) {
        System.out.println(selectedMovie);
    }

}
