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
}
