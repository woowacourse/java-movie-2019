package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {

    private List<Reservation> list = new ArrayList<>();

    public void addReservation(Reservation reservation){
        list.add(reservation);
    }

}
