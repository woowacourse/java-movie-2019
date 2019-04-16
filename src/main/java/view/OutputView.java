package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("##상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
