package view;

import domain.Movie;

import java.util.List;
import java.util.*;
public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static Movie printSelectMovie(List<Movie> movies, int inputNum) {
    	for (Movie movie: movies) {
    		if (movie.getId() == inputNum) {
    			System.out.println(movie);
    			return movie;
    		}
    	}
    	return null;
    }
    
    public static void printSelectTime(Movie movie, int inputNum) {
    	System.out.println(movie.getPlaySchedule().get(inputNum - 1));
    }
}
