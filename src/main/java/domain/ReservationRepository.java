package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private List<ReservationInfo> reservations = new ArrayList<>();

    public void add(ReservationInfo reservationInfo) {
        reservations.add(reservationInfo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ReservationInfo reservationInfo : reservations) {
            sb.append(reservationInfo);
        }
        return sb.toString();
    }
}
