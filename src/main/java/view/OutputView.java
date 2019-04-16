package view;


import domain.Movie;

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
            selectMovie_Add(movie,movie_id);
        }
        System.out.println(userMovie);
    }

    private static void selectMovie_Add(Movie movies, int movie_id){
        if (movies.movie_Id_Get(movie_id)){
            userMovie = movies;
        }
    }


    public static void userMovie_SelectDatatime(int movie_datatime){
        System.out.println(userMovie.getMovieDataTime(movie_datatime));
    }

}
