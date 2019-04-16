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

    public boolean movie_Id_Get(int input) {
        if (id != input) {
            return false;
        }
        return true;
    }

    public String getMovieDataTime(int datatime) {
        if (playSchedules.size() < datatime) {
            throw new IllegalArgumentException("해당 영화 시간은 없습니다");
        }
        return playSchedules.get(datatime).selctDatatime();
    }

    public int getMoviecapacity(int person) {
        return playSchedules.get(person).selectCapacity();
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
