import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reserve;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
    }
    public static void bookTicket( List<Reserve> reserveList){
        Movie userSelectMovie = selectMovie();
        PlaySchedule userSelectSchedule = selectSchedule(userSelectMovie);
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
    public static PlaySchedule selectSchedule(Movie userSelectMovie){
        int scheduleId = InputView.inputScheduleId();
        while(!userSelectMovie.isCorrectSheduleId(scheduleId)){
            scheduleId = InputView.inputScheduleId();
        }
        while(!userSelectMovie.isPossibleWatch(scheduleId)){
            System.out.println(InputView.NOT_MOVIE_SCHEDULE);
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
}
