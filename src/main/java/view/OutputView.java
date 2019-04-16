package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    private static final String ALL_MOVIES_GUIDE = "## 상영 영화 목록";

    public static void printMovies(List<Movie> movies) {
        System.out.println(ALL_MOVIES_GUIDE);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
