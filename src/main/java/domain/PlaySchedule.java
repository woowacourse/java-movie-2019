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

    public void buyTicket(int buyCount) {
        if (capacity - buyCount < 0) {
            throw new IllegalArgumentException("인원 초과입니다 다른 일정을 선택해주세요\n");
        }
        this.capacity -= buyCount;
    }

    public boolean isSchedulePossible() {
        return (capacity > 0 && isScheduleValidTime());
    }

    // 현재 시간 이후인지 체크
    private boolean isScheduleValidTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.isBefore(this.startDateTime);
    }

    // 1시간 이내인지 체크
    public boolean isOneHourWithinRangeSchedule(PlaySchedule inputSchedule) {
        return DateTimeUtils.isOneHourWithinRange(this.startDateTime, inputSchedule.startDateTime);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
