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
    public int getId() {
        return id;
    }
    public String getMovie() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public List<PlaySchedule> getPlaySchedules() {
        return this.playSchedules;
    }

//    public Movie isContains (int movieNum) {
//        if (this.id == movieNum){return this;}
//        throw new IllegalArgumentException(movieNum + "는 유효하지 않은 값입니다.");
//    }
}
