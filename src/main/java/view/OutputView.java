package view;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationMovieList;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(int movieId) {
        System.out.println(MovieRepository.getSelectedMovie(movieId));
    }

    public static void printReservation() {
        System.out.println(ReservationMovieList.getInstance());
    }
}
