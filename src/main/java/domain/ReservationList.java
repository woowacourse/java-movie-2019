package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {

    private List<Reservation> list = new ArrayList<>();

    private String RESERVATION_LIST_MESSAGE = "예약 내역";

    public void addReservation(Reservation reservation){
        list.add(reservation);
    }

    public void showResrvationList(){
        System.out.println(RESERVATION_LIST_MESSAGE);
        for(Reservation reservation: list){
            System.out.println(reservation);
        }
    }

}
