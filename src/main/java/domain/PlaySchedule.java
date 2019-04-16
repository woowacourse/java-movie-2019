package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public boolean isNotEmpty() {
        return capacity > 0;
    }

    public boolean isReservePossible(int count) {
        return capacity >= count;
    }

    public void showOnlyTimeInfo() {
        System.out.println("시작시간: " + format(startDateTime));
    }

    public void decreasePersonCount(int count) {
        capacity -= count;
    }
}
