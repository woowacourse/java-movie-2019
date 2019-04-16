package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printInputMovieSchedule(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                System.out.println(movie);
            }
        }
    }
}
