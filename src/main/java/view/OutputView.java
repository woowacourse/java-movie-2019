package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(List<Movie> moviesList, int movieId){
        Movie selectedMovie = null;
        for(Movie movie : moviesList){
            selectedMovie = movie.compareId(movieId) ? movie : selectedMovie;
        }
        System.out.println(selectedMovie.toString());
    }
}
