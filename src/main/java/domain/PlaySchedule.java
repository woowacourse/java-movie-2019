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

    public String getStartTimeString() {
        return "시작시간: " + format(startDateTime) + "\n";
    }

    public void scheduleReservation(int count) throws Exception {
        if (this.capacity - count < 0) {
            throw new Exception("예매 가능 인원을 초과합니다.");
        }
        this.capacity -= count;
    }
}
