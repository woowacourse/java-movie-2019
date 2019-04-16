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
    
    public boolean hasEnoughCapacity(int ticketCount) {
    	return ticketCount <= capacity;
    }
    
    public boolean isEnd() {
    	return LocalDateTime.now().isAfter(startDateTime);
    }
    
    public void reduceCapacity(int count) {
    	this.capacity -= count;
    }
}
