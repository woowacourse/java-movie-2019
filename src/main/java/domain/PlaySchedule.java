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

    public boolean isCapable(int numOfPeople) {
        return capacity >= numOfPeople && numOfPeople > 0;
    }

    public boolean isBookableWith(PlaySchedule otherSchedule) {
        return DateTimeUtils.isOneHourWithinRange(this.startDateTime, otherSchedule.startDateTime);
    }

    public boolean isBookableNow() {
        return isBookableAt(LocalDateTime.now());
    }

    private boolean isBookableAt(LocalDateTime now) {
        if (this.startDateTime.compareTo(now) >= 1) {
            // start > now;
            return true;
        }
        return false;
    }

    public void book(int numOfPeople) {
        if (!isCapable(numOfPeople)) {
            throw new IllegalArgumentException("Number of booking people can't over capacity.");
        }

        capacity -= numOfPeople;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }
}
