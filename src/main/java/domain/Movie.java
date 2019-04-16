package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final String INVALID_SCHEDULE_ID_ERROR_MESSAGE = "해당 번호에 해당하는 시간대가 존재하지 않습니다.";

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

    public Boolean isId(int id) {
        return this.id == id;
    }

    public PlaySchedule getSchedule(int id) {
        if (id >= 1 && id <= playSchedules.size()) {
            return playSchedules.get(id - 1);
        }
        throw new IllegalArgumentException("해당 번호에 해당하는 시간대가 존재하지 않습니다.");
    }

}
