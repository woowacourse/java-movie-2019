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

    public void buy(int peopleCount) {
        if (this.capacity < peopleCount) {
            throw new IllegalStateException("구매수제한 현재남은표 " + capacity);
        }
        this.capacity = capacity - peopleCount;
    }


    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isValidSchdule(LocalDateTime now) {
        if (this.getStartDateTime().isBefore(now)) {
            throw new IllegalStateException("시간이 지나 관람 불가");
        }
        return true;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
