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

    /**
     * 예약가능인원이 매개변수로 주어진 숫자 이상인지 확인한다.
     */
    public boolean isThisTimeAvailable(int numOfGuest) {
        return capacity >= numOfGuest;
    }
}