package domain;

public class MovieValidator {

    public static boolean isExistMovie(int movieId){
        return MovieRepository.getMovie(movieId) == null;
    }
}
