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

    public LocalDateTime getStartDateTime(){
        return this.startDateTime;
    }

    public void reserve(int reserveAmount){
        this.capacity -= reserveAmount;
    }

    public boolean isPossibleReserve(int reserveAmount){
        return reserveAmount > 0 && this.capacity >= reserveAmount;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
