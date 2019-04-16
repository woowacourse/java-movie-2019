package domain;

import java.util.List;

public class MovieService {
    public static Movie findMovieForId(List<Movie> movies, int movieId){
        for(Movie movie : movies){
            if(movie.isMatchedMovieId(movieId)){
                return movie;
            }
        }
        return null;
    }
}
