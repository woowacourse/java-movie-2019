package utils;

import domain.MovieRepository;
import view.OutputView;
import domain.Movie;

public class CheckException {
    public static void checkInMovieNum(int checkNum){
        if(MovieRepository.getMovieIdList().contains(checkNum)){
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkInMovieTime(Movie movie, int checkNum){
        if(movie.getScheduleSize() >= checkNum && checkNum > Constant.MIN_SCHEDULE_SIZE){
            return;
        }
        throw new IllegalArgumentException();
    }

//    public static void checkInAvailableTime(Movie movie, int checkNum){
//        if(movie.isMovieInTime(checkNum)){
//            return;
//        }
//        System.out.print("상영 시간이 이미 지났습니다.");
//        throw new IllegalArgumentException();
//    }
}
