package validator;

import domain.Movie;
import domain.MovieRepository;

import java.util.Set;

public class MovieListValidator implements Validator {

    private final Set<String> movieIdSet;

    public MovieListValidator(Set<String> movieIds) {
        movieIdSet = movieIds;
    }

    @Override
    public boolean doesValid() {
        return doesEachMovieInputIsValid()
                && doesEachMovieIdBelowMovieListLength();
    }

    boolean doesEachMovieInputIsValid() {
        return !movieIdSet.stream()
                .map(MovieInputValidator::new)
                .anyMatch((inputValidator) -> !inputValidator.doesValid());
    }

    boolean doesEachMovieIdBelowMovieListLength() {
        int movieListLen = MovieRepository.getMovies().size();
        return !movieIdSet.stream()
                .anyMatch((movieId) -> Integer.parseInt(movieId) > movieListLen);
    }
}
