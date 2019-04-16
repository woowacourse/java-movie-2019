package reservation;

import domain.Movie;
import domain.MovieRepository;

import java.util.ArrayList;

public class MovieReservation {
    private ArrayList<Movie> reservation = new ArrayList<>();

    public static int checkExistList(int movieId) {
        if (!MovieRepository.contain(movieId)) {
            throw new IllegalArgumentException();
        }
        return movieId;
    }
}
