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

    public boolean isValidCapacity(int personnel){
        if(personnel > capacity){
            return false;
        }
        applyPersonnelToCapacity(personnel);
        return  true;
    }

    private void applyPersonnelToCapacity(int personnel){
        this.capacity = this.capacity - personnel;
    }

    public LocalDateTime getStartDateTime(){
        return this.startDateTime;
    }

    public String printSchedule(){
        return "시작시간: " + format(startDateTime) + "\n";
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
