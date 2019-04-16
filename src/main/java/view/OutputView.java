package view;

import domain.Booking;
import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie, List<PlaySchedule> schedules) {
        System.out.println(movie);
        for (PlaySchedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

    public static void printBookings(List<Booking> bookings) {
        System.out.println("예약 내역");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
