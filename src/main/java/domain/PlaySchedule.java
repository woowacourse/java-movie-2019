package domain;

import java.time.LocalDateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.assertj.core.internal.bytebuddy.asm.Advice.Local;

import utils.DateTimeUtils;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }
    
    public boolean checkOneHourRange(PlaySchedule playSchedule) {
    	return DateTimeUtils.isOneHourWithinRange(this.startDateTime, playSchedule.startDateTime);
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
