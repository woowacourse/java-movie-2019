package domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public boolean matchCapacity(int capacity) {
        if ((capacity < 1) || (capacity > this.capacity)) {
            return false;
        }
        return true;
    }

    public boolean matchCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return startDateTime.isBefore(currentTime);
    }

    public boolean matchSchedule(LocalDateTime time) {
        if (ChronoUnit.HOURS.between(startDateTime, time) > 1){
            return false;
        }
        return true;
    }

    public String playTimeInformation() {
        return "시작시간: " + format(startDateTime) + "\n";
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public LocalDateTime getStartDateTime() {
        return  startDateTime;
    }
}
