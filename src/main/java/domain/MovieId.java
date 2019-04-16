package domain;

import java.util.ArrayList;
import java.util.List;

public class MovieId {
    private final int movieId;

    private boolean isValid(int movieId) {
        List<Movie> movies = MovieRepository.getMovies();
        List<Integer> movieIds = new ArrayList<>();

        for (Movie movie : movies) {
            movieIds.add(movie.getId());
        }

        return movieIds.contains(movieId);
    }

    public MovieId(int movieId) {
        if (!isValid(movieId)) {
            System.out.println("상형 목록에 없는 영화입니다.");
            throw new IllegalArgumentException();
        }

        this.movieId = movieId;
    }
}
