package utils;

import domain.MovieRepository;

public class ValidatorUtils {


    public static boolean isNaturalMovieId(int movieId) {
        return MovieRepository.containsMovieId(movieId);
    }

}
