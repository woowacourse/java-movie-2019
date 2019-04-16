package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class ReservationSchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + "\n예약 인원 : " + capacity + "\n";
    }

}
