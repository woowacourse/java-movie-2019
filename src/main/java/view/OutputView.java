package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printReservationHistory(int movieId, int movieTime, int movieViewer) {
        System.out.println("예약 내역");

        for (Movie movie : MovieRepository.getMovies(movieId)) {
            System.out.println(movie.toString(movieTime));
        }
        System.out.println("예약 인원: " + movieViewer + "명");
    }
}
