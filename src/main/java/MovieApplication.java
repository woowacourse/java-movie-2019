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
        OutputView.printMovies(movies);
        bookTicket(reserveList);
        int isContinue = InputView.inputContinue();
        while(isContinue != 1){
            bookTicket(reserveList);
            isContinue = InputView.inputContinue();
        }
        for(Reserve reserve : reserveList){
            reserve.printReserverInformation();
        }
    }
    public static void bookTicket( List<Reserve> reserveList){
        Movie userSelectMovie = selectMovie();
        PlaySchedule userSelectSchedule = selectSchedule(reserveList, userSelectMovie);
        int personCount = selectPerson(userSelectSchedule);
        reserveList.add(new Reserve(userSelectMovie,userSelectSchedule,personCount));
    }
    public static Movie selectMovie(){
        int movieId = InputView.inputMovieId();
        while(!MovieRepository.isContainMovieId(movieId)){
            System.out.println(InputView.NOT_MOVIE_ID);
            movieId = InputView.inputMovieId();
        }
        Movie userSelectMovie = MovieRepository.getMovie(movieId);
        System.out.println(userSelectMovie);
        return userSelectMovie;
    }
    public static PlaySchedule selectSchedule(List<Reserve> reserveList , Movie userSelectMovie){
        int scheduleId = InputView.inputScheduleId();
        while(!userSelectMovie.isCorrectScheduleId(scheduleId)){
            scheduleId = InputView.inputScheduleId();
        }
        while(!userSelectMovie.isPossibleWatch(scheduleId)){
            System.out.println(InputView.NOT_MOVIE_SCHEDULE);
            scheduleId = InputView.inputScheduleId();
        }
        while(isImpossibleSchedule(reserveList, userSelectMovie.getSchedule(scheduleId))){
            scheduleId = InputView.inputScheduleId();
        }
        return userSelectMovie.getSchedule(scheduleId);
    }
    public static int selectPerson(PlaySchedule userSelectSchedule){
        int personCount = InputView.inputPerson();
        while(!userSelectSchedule.isOverPerson(personCount)){
            System.out.println(InputView.OVER_RANGE_CAPACITY);
            personCount = InputView.inputPerson();
        }
        return personCount;
    }
    public static boolean isImpossibleSchedule(List<Reserve> reserveList, PlaySchedule userSelcetSchedule){
        boolean result = false;
        for(Reserve reserve : reserveList){
            result = result || !isOneHourWithinRange(reserve.getSchedule().getStartDateTime(), userSelcetSchedule.getStartDateTime());
        }
        if(result){
            System.out.println(InputView.OVER_ONEHOUR);
        }
        return result;
    }
}
