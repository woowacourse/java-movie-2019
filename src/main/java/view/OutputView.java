package view;


import domain.Movie;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    static Movie userMovie;

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void selectMovies(List<Movie> movies, int movie_id) {
        for (Movie movie : movies) {
            selectMovie_Add(movie, movie_id);
        }
        System.out.println(userMovie);
        selectMovie_break();
    }

    private static void selectMovie_Add(Movie movies, int movie_id) {
        if (movies.movie_Id_Get(movie_id)) {
            userMovie = movies;
        }
    }

    private static void selectMovie_break() {
        if (userMovie == null) {
            System.out.println("해당 영화가 없습니다.");
            System.exit(0);
        }
    }

    public static String userMovie_SelectDatatime(int movie_datatime) {

        return userMovie.getMovieDataTime(movie_datatime);
    }

    public static int userMovie_SelectCapacity(int movie_person){
        return userMovie.getMoviecapacity(movie_person);
    }
}
