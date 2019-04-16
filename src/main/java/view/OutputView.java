package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printSelectMovie(int movieId) {
        System.out.println(MovieRepository.getMovieForMovieId(movieId));
        System.out.println();
    }

    public static void printReservation(List<MovieReservation> reservationList) {
        System.out.println("예약 내역");
        for (MovieReservation movieReservation : reservationList) {
            System.out.println(movieReservation);
        }
    }
}
