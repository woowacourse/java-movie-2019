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

    public void printScheduleStartTime() {
        System.out.println("시작시간: " + format(startDateTime));
    }

    public boolean reserveTickets(int personCount, int minPersonCount) {
        if (personCount < minPersonCount) {
            System.out.println("한 명 이상의 예약이 필요합니다.");
            return false;
        }
        if (personCount > capacity) {
            System.out.println("예매 가능 인원을 초과하였습니다.");
            return false;
        }
        capacity -= personCount;
        return true;
    }
}
