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

    public boolean isTimePassed() {
        return LocalDateTime.now().isAfter(startDateTime);
    }

    public void reduceCapacity(int numToReserve) {
        if(numToReserve < 0)
            throw new IllegalArgumentException("0 또는 자연수를 입력해주세요.");
        if(capacity < numToReserve)
            throw new IllegalArgumentException("예매 가능 인원을 초과했습니다.");
        capacity -= numToReserve;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
