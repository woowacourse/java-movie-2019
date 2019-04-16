package domain;

import static utils.DateTimeUtils.format;

import java.time.LocalDateTime;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }
    
    public LocalDateTime getStartDateTime() {
    	return startDateTime;
    }
    
    public boolean isValidPeople(int people) {
    	return people <= capacity;
    }
    
    public void subtractCapacity(int ticket) {
    	capacity -= ticket;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
