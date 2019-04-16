package utils;

import domain.Movie;

import java.util.List;

public class MovieFunc {
    public static Movie getMovieSameId(int movieId, List<Movie> movies){
        for(Movie movie : movies){
            if(movie.getId() == movieId){
                return movie;
            }
        }
        throw new IllegalArgumentException(movieId + "는 유효하지 않은 값입니다.");
    }

    public static void DecCapa(Movie movie, int sch, int capacity){
        movie.DecCapacity(sch-1,capacity);
    }
}
