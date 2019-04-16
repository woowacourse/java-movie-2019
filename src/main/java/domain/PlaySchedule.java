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

    public static boolean compareTime(PlaySchedule schedule1,
                                      PlaySchedule schedule2) {
        return DateTimeUtils.isOneHourWithinRange(schedule1.startDateTime, schedule2.startDateTime);
    }

    public boolean overCapacity(Integer movieTicket) { return capacity < movieTicket; }

    public void printTime() {
        System.out.println("시작시간: " + format(startDateTime));
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
