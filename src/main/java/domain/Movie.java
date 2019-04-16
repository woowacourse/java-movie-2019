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

    public PlaySchedule getPlaySchedule(int playSchedule){
        return playSchedules.get(playSchedule-1);
    }

    public boolean isIdSelected(int id) {
        return this.id == id ? true : false;
    }

    public boolean isTherePlaySchedule(int selectedPlaySchedule) {
        return playSchedules.size() >= selectedPlaySchedule - 1;
    }

    public boolean isThereCapacity(int selectedPlaySchedule, int numberOfPeople) {
        return playSchedules.get(selectedPlaySchedule - 1).getCapacity() >= numberOfPeople;
    }

    public String getMovieInfo(){
        return  id + " - " + name + ", " + price + "원" + NEW_LINE;
    }

    public int getPrice() {
        return price;
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
