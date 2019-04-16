package view;

import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie getMoviePlaySchedule(int movieId) {
        Movie movie = MovieRepository.findMovieById(movieId);
        if (movie == null) {
            throw new IllegalArgumentException("해당 영화가 없습니다.");
        }
        System.out.println(movie.toString());
        return movie;
    }

    public static void printReservation(List<Reservation> reservationList) {
        for (Reservation reservation : reservationList) {
            System.out.println(reservation.toString());
        }
    }

    public static void printPaymentStart() {
        System.out.println("## 결제를 진행합니다.");
    }
}
