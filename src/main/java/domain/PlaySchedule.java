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

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String toStringForConfirm() {
        return "시작시간: " + format(startDateTime);
    }

    public boolean makeReserve(int numPeople) {
        if (capacity >= numPeople) {
            capacity -= numPeople;
            return true;
        }
        return false;
    }

    public boolean isOneHourWithinRange(PlaySchedule playSchedule) {
        return DateTimeUtils.isOneHourWithinRange(startDateTime, playSchedule.startDateTime);
    }

    public boolean isAlreadyStarted() {
        return LocalDateTime.now().isAfter(startDateTime);
    }
}
