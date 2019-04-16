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

    /*
     * 현재 시간이 영화 시작 시간보다 이후면 true (영화가 이미 시작했으면)
     */
    public boolean isOverStartTime() {
        return (LocalDateTime.now().isAfter(this.startDateTime));
    }

    /*
     * 요청 수가 예약 가능 인원보다 크면 true
     */
    public boolean isOverCapacity(int request) {
        return request > this.capacity;
    }
}
