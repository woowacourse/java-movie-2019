package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 예약자 정보를 관리하는 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
public class Reserver {
    private static final char NEW_LINE = '\n';

    private List<Reservation> reservationList = new ArrayList<>();

    void addReservation(Reservation reservation){
        reservationList.add(reservation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Reservation reservation : reservationList) {
            sb.append(reservation);
        }
        return "예약 내역" + NEW_LINE + sb.toString();
    }
}
