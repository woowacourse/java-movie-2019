package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static void printSelectMovie(List<Movie> movies, int inputNum) {
    	for (Movie movie: movies) {
    		if (movie.getId() == inputNum) {
    		System.out.println(movie);
    		}
    	}
    }
}
