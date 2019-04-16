package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private static List<Reservation> reservationList = new ArrayList<>();

    public static void addReservation(Movie movie, PlaySchedule schedule, int numToReserve){
        isOneHourWithinRange(schedule.getStartDateTime());
        Reservation reservation = new Reservation(movie.getId(), movie.getName(), movie.getPrice()
                                    ,schedule.getStartDateTime(), numToReserve);
        reservationList.add(reservation);
    }

    private static void isOneHourWithinRange(LocalDateTime schedule) {
        for(Reservation reservation : reservationList) {
            if(!DateTimeUtils.isOneHourWithinRange(reservation.getPlaySchedule(),schedule))
                throw new IllegalArgumentException("시간 차이가 1시간 이상입니다.");
        }
    }

    public static void printList() {
        for(Reservation reservation : reservationList) {
            System.out.println(reservation);
        }
    }
}
