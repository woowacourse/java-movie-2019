package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;
import static utils.DateTimeUtils.isTimePassed;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime)
                + " 예약가능인원: " + capacity + "\n";
    }

    void printScheduleStartTime() {
        System.out.println("시작시간: " + format(startDateTime));
    }

    /* 예약 인원이 유효할 시 예약 후 true return
     * 인원이 너무 많을 시 예약 없이 오류 출력 후 false return */
    public boolean reserveTickets(int personCount) {
        if (personCount > capacity) {
            System.out.println("예매 가능 인원을 초과하였습니다.");
            return false;
        }
        capacity -= personCount;
        return true;
    }

    // 현재 시간과 비교하여 상영 시간이 지났는지 확인
    public boolean isStartTimePassed() {
        return isTimePassed(startDateTime);
    }

    boolean isWithinOneHour(PlaySchedule anotherSchedule) {
        return anotherSchedule.isOneHourWithinRange(startDateTime);
    }

    private boolean isOneHourWithinRange(LocalDateTime anotherDateTime) {
        return DateTimeUtils.isOneHourWithinRange(anotherDateTime, startDateTime);
    }
}
