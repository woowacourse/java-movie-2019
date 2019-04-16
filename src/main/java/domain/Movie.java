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
    
    public boolean isTheMovie(int id) {
    	return this.id == id;
    }
    
    public boolean isValidSchedule(int select) {
    	int sizeOfSchedule = playSchedules.size();
    	return select <= sizeOfSchedule && select > 0;
    }
    
    public int getId() {
    	return id;
    }
    
    public PlaySchedule getSchedule(int index) {
    	return playSchedules.get(index-1);
    }
    
    public String getFirstLine() {
    	return id + " - " + name + ", " + price + "원" + NEW_LINE;
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
