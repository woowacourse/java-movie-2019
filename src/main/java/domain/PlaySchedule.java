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

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public void checkPersonOverCapacity(int theNumberOfPerson){
         if(theNumberOfPerson > capacity){
             throw new IllegalArgumentException("예약가능 인원을 초과했습니다.");
         }
    }

    public boolean checkOneHourGapwithOthers(PlaySchedule playSchedule) {
        return playSchedule.checkOtherScheduleTime(startDateTime);
    }

    private boolean checkOtherScheduleTime(LocalDateTime otherLocalDateTime){
        return DateTimeUtils.isOneHourWithinRange(startDateTime, otherLocalDateTime);
    }
}
