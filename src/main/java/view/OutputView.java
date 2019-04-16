package view;

import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMoviePlaySchedule(List<Movie> movies, int movieId){
        for(Movie movie : movies){
            findMovieForId(movie, movieId);
        }
    }

    private static void findMovieForId(Movie movie, int movieId){
        if(movie.isMatchedMovieId(movieId)){
            System.out.println(movie);
        }
    }
}
