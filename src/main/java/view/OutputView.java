package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectMovie(int selectMovieId) {
        System.out.println(MovieRepository.getSelectMovie(selectMovieId));

    }
}
