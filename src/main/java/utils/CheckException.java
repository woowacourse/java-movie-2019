package utils;

import domain.MovieRepository;
import view.OutputView;
import domain.Movie;

public class CheckException {

    public static void checkInMovieNum(int checkNum) {
        if (MovieRepository.getMovieIdList().contains(checkNum)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkInMovieTime(Movie movie, int checkNum) {
        if (movie.getScheduleSize() >= checkNum && checkNum > Constant.MIN_SCHEDULE_SIZE) {
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

    public static void checkcheckCapacity(Movie movie, int checkNum, int movieTime) {
        if (movie.getCapacity(movieTime) >= checkNum && checkNum > Constant.MIN_PEOPLE_SIZE) {
            return;
        }
        OutputView.printNotInPeopleNum();
        throw new IllegalArgumentException();
    }

    public static void checkZeroOne(int checkNum) {
        if (checkNum == Constant.CONTINUE_NUM || checkNum == Constant.END_NUM) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkPointInPrice(int point, int price) {
        if (point <= price && point > Constant.MIN_POINT) {
            return;
        }
        OutputView.pointOverPrice();
        throw new IllegalArgumentException();
    }
}
