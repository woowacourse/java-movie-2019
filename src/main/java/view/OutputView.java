package view;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationStorage;
import domain.ReservedMovie;

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

    public static void printAllReservedMovies(ReservationStorage reservationStorage) {
        System.out.println("예약 내역");
        for (ReservedMovie reservedMovie : reservationStorage.getMoviesToReserve()) {
            System.out.println(reservedMovie);
        }
    }
}
