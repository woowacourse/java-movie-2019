package reservation;

import domain.Movie;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

public class ReservationMain {
    public static MovieReservation reservationRun(MovieReservation reservations) {
        PlaySchedule schedule;
        int reservePeopleNum;
        int movieId = InputView.inputMovieId();
        Movie selectedMovie = OutputView.printPlaySchedule(movieId);
        do {
            schedule = InputView.inputPlaySchedule(selectedMovie);
        } while (!reservations.checkVaildSchedule(schedule));
        reservePeopleNum = InputView.inputReservationPeople(schedule);
        reservations.insertRervation(selectedMovie, schedule, reservePeopleNum);
        return reservations;
    }
}
