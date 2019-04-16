package domain;

import java.util.List;

public class Reservation {
    private static List<Movie> movies = MovieRepository.getMovies();
    private final int movieId;
    private final int movieTime;
    private final int numOfGuest;

    public Reservation(int movieId, int movieTime, int numOfGuest) {
        this.movieId = movieId;
        this.movieTime = movieTime;
        this.numOfGuest = numOfGuest;
    }
}