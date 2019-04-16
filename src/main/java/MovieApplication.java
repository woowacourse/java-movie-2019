import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        ReservationManager reservationManager = new ReservationManager();
        reservationManager.initReservation();
    }
}
