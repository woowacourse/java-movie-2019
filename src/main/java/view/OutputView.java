package view;

import domain.Movie;

import java.util.Map;

public class OutputView {
    public static void printMovies(Map<Integer, Movie> movies) {
        for(int key : movies.keySet()){
            System.out.println(movies.get(key));
        }
    }

    public static void printMovieInfo(Movie movie){
        System.out.println(movie);
    }
/*
    public static void printReservation(){

    }
*/
}
