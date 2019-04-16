package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final int MIN_BOOKING_NUMBER = 1;

    private final LocalDateTime startDateTime;
    private int capacity;

    PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    boolean isValidityCapacity(int bookingNumber){
        return ((MIN_BOOKING_NUMBER <= bookingNumber) && (bookingNumber <= capacity));
    }

    LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
