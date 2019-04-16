package view;

import domain.Movie;
import domain.BookedMovie;

import java.util.List;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public static void printMovies(List<Movie> movies) {
        System.out.println(NEW_LINE + "## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie selectedMovie) {
        System.out.println(selectedMovie);
    }

    public static void printBookedMovies(List<BookedMovie> bookedMovies) {
        System.out.println("예약 내역");
        for (BookedMovie b : bookedMovies) {
            b.printReservation();
        }
    }
}
