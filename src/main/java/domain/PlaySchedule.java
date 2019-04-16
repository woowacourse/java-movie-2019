package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.Date;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    /*public LocalDateTime getStartDateTime(){
        return startDateTime;
    }*/

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public boolean isValidCapacity(int audience) {
        return audience <= capacity;
    }

    public boolean compare(PlaySchedule other){
        return DateTimeUtils.isOneHourWithinRange(startDateTime, other.startDateTime);
    }

    public boolean updateCapacity(int audience){
        if(capacity >= audience){
            capacity -= audience;
            return true;
        }
        System.out.println("다시 입력해주세요");
        return false;
    }
}
