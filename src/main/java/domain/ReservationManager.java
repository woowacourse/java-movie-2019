package domain;

import view.InputView;
import java.util.HashMap;

public class ReservationManager {
    public static Reservation getReservation() {
        try {
            MovieId movieId = InputView.inputMovieId();
            ScheduleNumber scheduleNumber = InputView.inputScheduleNumber();
            NumberOfPeople numberOfPeople = InputView.inputNumberOfPeople();
            return new Reservation(movieId, scheduleNumber, numberOfPeople);
        } catch (IllegalArgumentException e) {
            return getReservation();
        }
    }

    public static void addReservationTo(HashMap<MovieId, Reservation> reservations,
                                        Reservation reservation) {
    }

    public static boolean continueReservation() {
        return false;
    }

    public static void startPaymentOf(HashMap<MovieId, Reservation> reservations) {

    }
}
