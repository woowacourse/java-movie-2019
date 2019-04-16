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

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isCapacityNotZero(){
        if(capacity == 0){
            return false;
        }
        return true;
    }

    public boolean isInnerCapacity(int capa){
        if(capa > 0 && capa <= capacity){
            return true;
        }
        return false;
    }
}
