package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie selectMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.isThisMovie(movieId)) {
                return movie; // TODO: 차후에 depth를 1칸 줄인다.
            }
        }
        return null;
    }
}
