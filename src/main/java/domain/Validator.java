package domain;

import java.util.List;

public class Validator {
    private static List<Movie> movies = MovieRepository.getMovies();

    public static void checkMovieId(int movieId) {
        for (Movie movie : movies) {
            if (movie.isEqual(movieId)) return; // indent 2
        }
        throw new IllegalArgumentException("sorry");
    }
}
