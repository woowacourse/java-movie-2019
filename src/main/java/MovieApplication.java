import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reserve;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import static utils.DateTimeUtils.isOneHourWithinRange;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<Reserve> reserveList = new ArrayList<>();
        int price = 0;
        OutputView.printMovies(movies);
        bookTicket(reserveList);
        int isContinue = intputContinue();
        while(isContinue != 1){
            bookTicket(reserveList);
            isContinue = intputContinue();
        }
        for(Reserve reserve : reserveList){
            price = price + reserve.getPrice();
            reserve.printReserverInformation();
        }

        int point = inputPoint(price);
        int cashOrCredit = intputCashOrCredit();
        OutputView.printResult(cashOrCredit,price-point);
    }
    private static void bookTicket( List<Reserve> reserveList){
        Movie userSelectMovie = selectMovie();
        PlaySchedule userSelectSchedule = selectSchedule(reserveList, userSelectMovie);
        int personCount = selectPerson(userSelectSchedule);
        reserveList.add(new Reserve(userSelectMovie,userSelectSchedule,personCount));
    }
    private static Movie selectMovie(){
        int movieId = InputView.inputMovieId();
        while(!MovieRepository.isContainMovieId(movieId)){
            System.out.println(InputView.NOT_MOVIE_ID);
            movieId = InputView.inputMovieId();
        }
        Movie userSelectMovie = MovieRepository.getMovie(movieId);
        System.out.println(userSelectMovie);
        return userSelectMovie;
    }
    private static PlaySchedule selectSchedule(List<Reserve> reserveList , Movie userSelectMovie){
        int scheduleId = InputView.inputScheduleId();
        while(!userSelectMovie.isCorrectScheduleId(scheduleId))
            scheduleId = InputView.inputScheduleId();
        while(!userSelectMovie.isPossibleWatch(scheduleId)){
            System.out.println(InputView.NOT_MOVIE_SCHEDULE);
            scheduleId = InputView.inputScheduleId();
        }
        while(userSelectMovie.isImpossibleSchedule(reserveList, scheduleId))
            scheduleId = InputView.inputScheduleId();
        return userSelectMovie.getSchedule(scheduleId);
    }
    private static int selectPerson(PlaySchedule userSelectSchedule){
        int personCount = InputView.inputPerson();
        while(!userSelectSchedule.isOverPerson(personCount)){
            System.out.println(InputView.OVER_RANGE_CAPACITY);
            personCount = InputView.inputPerson();
        }
        return personCount;
    }
    private static int inputPoint(int price){
        int point = InputView.inputPoint();
        while(point > price){
            System.out.println(InputView.OVER_POINT);
            point = InputView.inputPoint();
        }
        return point;
    }
    public static int intputContinue(){
        int isContinue = InputView.inputContinue();
        while(isContinue != 1 && isContinue != 2){
            System.out.println(InputView.OneOrTwu);
            isContinue = InputView.inputContinue();
        }
        return isContinue;
    }
    public static  int intputCashOrCredit(){
        int cashOrCredit = InputView.intputCashOrCredit();
        while(cashOrCredit != 1 && cashOrCredit != 2){
            System.out.println(InputView.OneOrTwu);
            cashOrCredit = InputView.intputCashOrCredit();
        }
        return cashOrCredit;
    }
}
