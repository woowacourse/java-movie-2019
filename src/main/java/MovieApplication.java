import domain.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MovieApplication {
    public static void main(String[] args) {
        HashMap<MovieId, Reservation> reservations = new LinkedHashMap<>();

        do {
            ReservationManager.addReservationTo(reservations);
        } while(ReservationManager.continueReservation());

        ReservationManager.startPaymentOf(reservations);
    }
}
