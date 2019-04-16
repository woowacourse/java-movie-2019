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
                .noneMatch((inputValidator) -> inputValidator.doesValid());
    }

    private boolean doesEachMovieIdExist() {
        List<Movie> movieList = MovieRepository.getMovies();
        return !movieIdSet.stream()
                .noneMatch((movieId) -> {
                    return MovieRepository.contains(Integer.parseInt(movieId));
                });
    }
}
