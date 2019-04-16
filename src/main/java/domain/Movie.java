package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public boolean isSameMovie(int movieNumber) {
        return id == movieNumber;
    }

    public boolean vacancyExist() {
        return playSchedules.stream().anyMatch(schedule -> schedule.isNotEmpty());
    }

    public boolean isScheduleExist(int scheduleIndex) {
        return (playSchedules.size() - 1 >= scheduleIndex);
    }

    public PlaySchedule getSchedule(int indexIndex) {
        return playSchedules.get(indexIndex);
    }

    public void showBasicInfo() {
        System.out.println(id + " - " + name + ", " + price + "원");
    }

    public int calculateTotalReserveMoney(int personCount) {
        return price * personCount;
    }

    public void decreaseScheduleCapacity(int scheduleIndex, int personCount) {
        PlaySchedule reserveSchedule = playSchedules.get(scheduleIndex);
        reserveSchedule.decreasePersonCount(personCount);
    }
}
