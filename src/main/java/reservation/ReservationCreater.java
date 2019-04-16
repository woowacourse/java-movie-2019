package reservation;

import domain.Movie;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

class ReservationCreater {
    static Movie inputMovie(int movieId) {
        return OutputView.printPlaySchedule(movieId);
    }

    static PlaySchedule inputSchedule(MovieReservation reservations, Movie selectedMovie) {
        PlaySchedule schedule;
        do {
            schedule = InputView.inputPlaySchedule(selectedMovie);
        } while (!reservations.checkVaildSchedule(schedule));
        return schedule;
    }

    static int inputReserveNum(PlaySchedule schedule) {
        return InputView.inputReservationPeople(schedule);
    }
}
