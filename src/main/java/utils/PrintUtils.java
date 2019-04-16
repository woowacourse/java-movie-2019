package utils;

import domain.Movie;

import java.util.List;

public class PrintUtils {
        public static void printSelectedMovie(List<Movie> moviesList, int movieId){
                Movie selectedMovie = null;
                for(Movie movie : moviesList){
                        selectedMovie = movie.compareId(movieId) ? movie : selectedMovie;
                }
                System.out.println(selectedMovie.toString());
        }
}
