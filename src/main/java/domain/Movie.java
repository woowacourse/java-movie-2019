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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public int getPrice() {
        return price;
    }

    public boolean hasID(int id) {
        return this.id == id;
    }

    public boolean canAccessSchedule(int idx) {
        return 0 <= idx && idx < playSchedules.size();
    }

    public PlaySchedule getPlaySchedule(int idx) {
        return playSchedules.get(idx);
    }

    public void reserve(MovieReservation reservation) {
        PlaySchedule schedule = getSchedule(reservation.getTime());
        schedule.use(reservation.getNumReserve());
    }

    private PlaySchedule getSchedule(LocalDateTime time) {
        for (PlaySchedule schedule : playSchedules) {
            if (schedule.getStartDateTime().equals(time)) {
                return schedule;
            }
        }
        //
        return null;
    }
}
