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

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printMovie(int movieId) {
        List<Movie> movies = MovieRepository.getMovies();
        Movie movieToPrint = (Movie) movies.stream().filter(movie -> movie.isSameId(movieId)).toArray()[0];
        printMovie(movieToPrint);
    }
}
