package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

/**
 * 영화 스케줄과 예약 가능한 인원을 관리하는 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
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

    public boolean isPossibleReserve(int reservationNum){
        return this.capacity >= reservationNum;
    }

    public void updateCapacity(int reservationNum){
        this.capacity -= reservationNum;
    }
}
