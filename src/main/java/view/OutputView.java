package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieInfo(String movie){
        System.out.println(movie);
    }

    public static void printMoviePayState(String movie, String movieTime, int people){
        System.out.println(movie);
        System.out.println(movieTime);
        System.out.println("예약 인원 : " + people + "명");
    }
}
