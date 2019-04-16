package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void PrintChoiceMovie(List<Movie> movies, int movie_id)
    {
        int choice=0;
        if(movie_id==1)
            choice=0;
        if(movie_id==5)
            choice=1;
        if(movie_id==7)
            choice=2;
        if(movie_id==8)
            choice=3;
        System.out.println(movies.get(choice));
    }

}
