package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class ReservationSchedule extends PlaySchedule {

    public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
        super(startDateTime, capacity);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(super.getStartDateTime()) + "\n예약 인원 : " + super.getCapacity() + "\n";
    }

}
