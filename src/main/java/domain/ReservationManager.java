package domain;

import view.InputView;
import java.util.HashMap;

public class ReservationManager {
    public static Reservation getReservation() {
        try {
            MovieId movieId = InputView.inputMovieId();
            ScheduleNumber scheduleNumber = InputView.inputScheduleNumberOf(movieId.getMovieId());
            NumberOfPeople numberOfPeople = InputView.inputNumberOfPeople(movieId.getMovieId(),
                    scheduleNumber.getScheduleNumber());
            return new Reservation(movieId, scheduleNumber, numberOfPeople);
        } catch (IllegalArgumentException e) {
            return getReservation();
        }
    }

    public static void addReservationTo(HashMap<MovieId, Reservation> reservations,
                                        Reservation reservation) {
        MovieId movieId = reservation.getMoiveId();

        reservations.put(movieId, reservation);
    }

    public static boolean continueReservation() {
        String continuingReservatoion = InputView.inputContinueReservation();

        if (continuingReservatoion.equals("1")) {
            return false;
        }
        if (continuingReservatoion.equals("2")) {
            return true;
        }

        System.out.println("잘못된 입력입니다.");
        return continueReservation();
    }

    public static void showReservations(HashMap<MovieId, Reservation> reservations) {

    }

    public static void startPaymentOf(HashMap<MovieId, Reservation> reservations) {

    }
}
