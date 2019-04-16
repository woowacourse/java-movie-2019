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

    boolean matchId(Integer id) {
        return id.equals(this.id);
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

    boolean isEntryExists(Integer movieEntryNumber) {
        return movieEntryNumber <= playSchedules.size() && movieEntryNumber > 0;
    }

    boolean isConsumable(Integer movieEntryNumber, Integer capacity) {
        return isEntryExists(movieEntryNumber)
            && playSchedules.get(movieEntryNumber - 1).canConsume(capacity);
    }

    void consumeCapacity(Integer movieEntryNumber, Integer capacity) {
        playSchedules.get(movieEntryNumber).consume(capacity);
    }
}
