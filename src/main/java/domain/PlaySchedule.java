package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isOverPerson(int personCount) {
        return personCount <= capacity;
    }

    void printSchedule() {
        System.out.println("시작시간: " + format(startDateTime));
    }
}
