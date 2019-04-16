package utils;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class MovieDataRequester {

    public static Movie getMovie(int movieId) {
        List<Movie> movies = MovieRepository.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).isSameMovie(movieId)) {
                return movies.get(i);
            }
        }
        return null;
    }
}
