package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

/**
 * 기보생성자 추가 안됨
 * private 변경안됨
 * 필드 추가 안됨
 */
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

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
