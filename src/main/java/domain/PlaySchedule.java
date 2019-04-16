package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public boolean checkCapacity(int capacity) {
        if (this.capacity >= capacity) {
            return false;
        }
        System.out.println("예약인원을 초과했습니다.");
        return true;
    }

    public boolean checkStartDateTime(LocalDateTime now) {
        return startDateTime.isAfter(now);
    }

    public boolean checkOneHour(PlaySchedule playSchedule) {
        return DateTimeUtils.isOneHourWithinRange(startDateTime, playSchedule.startDateTime);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
