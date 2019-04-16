package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Reservation> reservationList = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public List<Reservation> getReservationList(){
        return this.reservationList;
    }

    public int sumOfPrice() {
        int sumOfPrice = 0;
        for (Reservation reservation : reservationList) {
            sumOfPrice += reservation.price();
        }
        return sumOfPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Reservation reservation : reservationList) {
            sb.append(reservation.toString())
                    .append("\n");
        }
        return sb.toString();
    }

}
