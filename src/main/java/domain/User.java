package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Reservation> reservationList=new ArrayList<>();

    public void addReservation(Reservation reservation){
        reservationList.add(reservation);
    }

    public int sumOfPrice(){
        int sumOfPrice=0;
        for(Reservation reservation : reservationList){
            sumOfPrice+= reservation.price();
        }
        return sumOfPrice;
    }

}
