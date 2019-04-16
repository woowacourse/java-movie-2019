package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieInfo(List<Movie> movies, int id){
        for(Movie i : movies){
            if(i.getId() == id){
                System.out.println(i);
            }
        }
    }
}
