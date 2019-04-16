package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final int MIN_NUM_OF_PEOPLE_TO_RESERVE = 1;
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public boolean isBefore() {
        return DateTimeUtils.isBefore(startDateTime);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public boolean isCapacious(int peopleToReserve) {
        return ((peopleToReserve >= MIN_NUM_OF_PEOPLE_TO_RESERVE) && (peopleToReserve <= capacity));
    }
}
