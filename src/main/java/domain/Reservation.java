package domain;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private final int Reserveid;
    private final int ReserveScheduleNum;
    private final int ReservePeopleNum;

    private List<Reservation> ReservationList = new ArrayList<>();

    public Reservation(int Reserveid, int ReserveScheduleNum, int ReservePeopleNum) {
        this.Reserveid = Reserveid;
        this.ReserveScheduleNum = ReserveScheduleNum;
        this.ReservePeopleNum = ReservePeopleNum;
    }
    void addReservation(Reservation reserve )
    {
        ReservationList.add(reserve);
    }

    List<Reservation> getReservation()
    {
        return ReservationList;
    }
}
