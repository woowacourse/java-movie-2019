package managers;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ReservationManager {
    public static void makeReservation() {
        printMovieList();
        try {
            int movieId = InputView.inputMovieId();
            Movie movie = MovieRepository.getMovieWithId(movieId);

            int scheduleNo = InputView.inputScheduleNo();
            PlaySchedule schedule = movie.getScheduleByNum(scheduleNo);

            int numToReserve = InputView.inputNumToReserve();
            schedule.reduceCapacity(numToReserve);

            ReservationRepository.addReservation(movie,schedule,numToReserve);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()+'\n');
            makeReservation();
        }
    }

    private static void printMovieList() {
        System.out.println("## 상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public static void printReservationList() {
        System.out.println("예약내역");
        ReservationRepository.printList();
    }


}
