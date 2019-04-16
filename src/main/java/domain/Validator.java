package domain;

import java.util.List;

public class Validator {
    private static List<Movie> movies = MovieRepository.getMovies();

    public static void checkMovieId(int movieId) {
        for (Movie movie : movies) {
            if (movie.isEqualMovie(movieId)) return; // indent 2
        }
        throw new IllegalArgumentException();
    }

    public static void checkMovieTime(int movieId, int movieTime) {
        Movie movie = MovieRepository.getMovie(movieId);
        checkRightMovieTime(movie, movieTime);
        checkAvailableSeats(movie, movieTime);
    }

    public static void checkRightMovieTime(Movie movie, int movieTime) {
        if (movieTime >= 0 && movie.isValidMovieTime(movieTime)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkAvailableSeats(Movie movie, int movieTime) {
        if (movie.isThisTimeAvailable(movieTime)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
