package domain;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private final int Reserveid;
    private final int ReserveScheduleNum;
    private final int ReservePeopleNum;



    public Reservation(int Reserveid, int ReserveScheduleNum, int ReservePeopleNum) {
        this.Reserveid = Reserveid;
        this.ReserveScheduleNum = ReserveScheduleNum;
        this.ReservePeopleNum = ReservePeopleNum;
    }


}
