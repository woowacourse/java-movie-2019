package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void searchMovieOfChoice(List<Movie> movies,int id){
        for(Movie movie:movies) {
            printMovieOfChoice(movie,id);
        }
    }

    public static void printMovieOfChoice(Movie movie,int id){
        if(movie.getId() == id){
            System.out.println(movie);
        }
    }
}
