package domain;

import java.time.LocalDateTime;
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

    LocalDateTime getStartDateTime(int scheduleNumber) {
        return playSchedules.get(scheduleNumber - 1).getStartDateTime();
    }

    boolean notThisMovie(int movieID) {
        return id != movieID;
    }

    boolean cantSchedule(int scheduleNumber) {
        return (scheduleNumber <= 0 || scheduleNumber > playSchedules.size());
    }

    boolean overPersonReservation(int scheduleNumber, int numberOfPerson) {
        return playSchedules.get(scheduleNumber - 1).notOkReservation(numberOfPerson);
    }

    Reservation reservation(int scheduleNumber, int numberOfPerson) {
        playSchedules.get(scheduleNumber - 1).reduceCapacity(numberOfPerson);
        return new Reservation(playSchedules.get(scheduleNumber - 1).getStartDateTime());
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
}
