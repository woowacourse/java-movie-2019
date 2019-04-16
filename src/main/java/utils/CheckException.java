package utils;

import domain.MovieRepository;
import view.OutputView;

public class CheckException {
    public static void checkInMovieNum(int checkNum){
        if(MovieRepository.getMovieIdList().contains(checkNum)){
            return;
        }
        throw new IllegalArgumentException();
    }
}
