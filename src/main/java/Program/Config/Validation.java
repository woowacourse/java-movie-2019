package Program.Config;

import domain.Movie;
import domain.MovieRepository;

public class Validation {
    public static void checkBookingPeopleNumber(int available, int want) throws Exception{
        if(available-want >= 0){
            return;
        }
        throw new Exception();
    }
    public static void checkMovieId(){
        for(Movie movie : MovieRepository.getMovies()){

        }
        
    }
}
