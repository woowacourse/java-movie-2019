package view;

import domain.Movie;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieInfo(Map<Integer, Movie> movies, int id){
        if(movies.containsKey(id)){
            System.out.println(movies.get(id));
        }
    }
}
