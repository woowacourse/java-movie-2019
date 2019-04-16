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

    public boolean isMyMovieId(int movieId) {
        if (movieId == id) {
            return true;
        }
        return false;
    }

    public void validateSchedule(int scheduleNumber) throws IllegalArgumentException {
        if (playSchedules.size() < scheduleNumber) {
            throw new IllegalArgumentException("존재하지 않는 상영 시간입니다.");
        }
        playSchedules.get(scheduleNumber - 1).validateSchedule();
    }

    public void validateWatcher(int watcher, int scheduleNumber) throws IllegalArgumentException {
        playSchedules.get(scheduleNumber - 1).validateWatcher(watcher);
    }
}
