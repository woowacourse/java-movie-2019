package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isFull(int n) {
        return !(capacity - n > 0);
    }

    public boolean withinRangeOneHour(PlaySchedule playSchedule) {
        return DateTimeUtils.isOneHourWithinRange(this.startDateTime, playSchedule.startDateTime);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
