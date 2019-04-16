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
    public static void checkMovieId(int wantId) throws Exception{
        for(Movie movie : MovieRepository.getMovies()){
            if(movie.getId() == wantId){
                return;
            }
        }
        System.out.println("존재 하지 않는 영화 id입니다. ");
        throw new Exception();
    }

    public static void checkScheduleSize(int order,int schedual) throws Exception{
        if(schedual <= MovieRepository.getMovies().get(order).getPlaySchedules().size()){
            return;
        }
        throw new Exception();
    }

    public static void checkPaymentType(int type) throws Exception{
        if(type==1 || type ==2){
            return;
        }
        throw new Exception();
    }
}
