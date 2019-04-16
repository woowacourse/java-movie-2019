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

    public boolean checkCapacity(int capacity) {
        if (this.capacity >= capacity) {
            return false;
        }
        System.out.println("범위를 벗어났습니다.");
        return true;
    }

    public boolean checkStartDateTime(LocalDateTime now) {
        return startDateTime.isAfter(now);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
