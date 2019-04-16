package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void prinitSelectedMovie(List<Movie> movies, int movieId) { // 수정 필요, indent 2
        for (Movie movie : movies) {
            if (movie.isEqual(movieId)) {
                System.out.println(movie);
            }
        }
    }
}
