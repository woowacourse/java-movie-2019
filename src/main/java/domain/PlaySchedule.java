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

    public LocalDateTime getTime() {
        return startDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void declineCnt(int cnt) {
        capacity -= cnt;
    }

    public void plusCnt(int cnt) {
        capacity += cnt;
    }
}
