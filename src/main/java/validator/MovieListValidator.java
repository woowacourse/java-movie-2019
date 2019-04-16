package validator;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class MovieListValidator implements Validator {

    private final List<String> movieIdSet;

    public MovieListValidator(List<String> movieIds) {
        movieIdSet = movieIds;
    }

    @Override
    public boolean doesValid() {
        return doesEachMovieInputIsValid()
                && doesEachMovieIdExist();
    }

    private boolean doesEachMovieInputIsValid() {
        return !movieIdSet.stream()
                .map(MovieInputValidator::new)
                .anyMatch((inputValidator) -> !inputValidator.doesValid());
    }

    private boolean doesEachMovieIdExist() {
        return !movieIdSet.stream()
                .anyMatch((movieId) -> {
                    return !MovieRepository.contains(Integer.parseInt(movieId));
                });
    }
}
