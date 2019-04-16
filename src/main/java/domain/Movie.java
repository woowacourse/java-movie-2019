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

    public void validateWatcher(int watcher, PlaySchedule playSchedule) throws IllegalArgumentException {
        playSchedule.validateWatcher(watcher);
    }

    public void applyWatcher(int watcher, PlaySchedule playSchedule) {
        playSchedule.decreaseCapacity(watcher);
    }

    public PlaySchedule getPlaySchedule(int scheduleNumber) {
        validateSchedule(scheduleNumber);
        return playSchedules.get(scheduleNumber - 1);
    }

    private void validateSchedule(int scheduleNumber) throws IllegalArgumentException {
        if (playSchedules.size() < scheduleNumber) {
            throw new IllegalArgumentException("존재하지 않는 상영 시간입니다.");
        }
        playSchedules.get(scheduleNumber - 1).validateSchedule();
    }

    public void istmp(PlaySchedule playSchedule) {

    }
}
