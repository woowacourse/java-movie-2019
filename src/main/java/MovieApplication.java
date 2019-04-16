import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservationMachine;
import domain.User;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        boolean isEnd = false;
        while (!isEnd) {
            MovieReservationMachine.showAvailableMovies();
            int userMovieId = User.selectMovie();
            MovieReservationMachine.showSchedulesOfMovieWithId(userMovieId);
            int userScheduleId = User.selectSchedule(userMovieId);
            int userPersonnels = User.selectPersonnels(userMovieId, userScheduleId);
            MovieReservationMachine.addReservation(userMovieId, userScheduleId, userPersonnels);
            isEnd = User.isEndReservation();
        }
        MovieReservationMachine.showReservatoinHistory();
        int point = User.selectPointUse();
        int howToPay = User.selectPaymentMethod();
    }
}
