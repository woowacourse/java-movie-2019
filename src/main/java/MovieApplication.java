import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {


    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        User user=new User();
        Reservation reservation;

        int movieId=movieIdInit();
        OutputView.printMovieById(movieId);

        int scheduledNumber=scheduleNumberInit(movies,movieId);
        int numberOfPeople=InputView.inputNumberOfPeople();

        reservation=new Reservation(movieId,scheduledNumber,numberOfPeople);
        user.addReservation(reservation);
        MovieRepository.getMovieById(movieId).getPlaySchedule(scheduledNumber).subCapacity(numberOfPeople);

        int isContinue=InputView.inputContinue();
        if(isContinue==1) {
            OutputView.printUserReservationList(user.getReservationList());

        }
        else{

        }

    }

    public static int movieIdInit(){
        int movieId;
        do {
            movieId = InputView.inputMovieId();
        }
        while (!MovieRepository.isContains(movieId));
        return movieId;
    }

    public static int scheduleNumberInit(List<Movie> movies, int movieId){
        int scheduledNumber;
        do {
            scheduledNumber = InputView.inputMovieSchedule();
        }
        while (scheduledNumber > movies.get(movieId).getScheduleSize()
                || MovieRepository.getMovieById(movieId).getPlaySchedule(scheduledNumber-1).getCapacity() <= 0);
        return scheduledNumber;
    }

}
