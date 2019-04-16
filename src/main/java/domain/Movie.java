package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;
    private final int idxMinus = 1;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getMovieId() {
		return id;
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
    
    public boolean isMovieId(int movieId) {
    	if (this.id == movieId) {
			return true;
		}
    	return false;
    }

    public boolean isValidSchedule(int movieScheduleId) {
    	PlaySchedule playSchedule = 
    			playSchedules.get(movieScheduleId-idxMinus);
		if (playSchedule.isSchedule()) {
			return true;
		}
    	return false;
    }

    public boolean isValidCapacity(int purchaseAmount) {
    	for (PlaySchedule playSchedule : playSchedules) {
    		if (playSchedule.isCapacity(purchaseAmount)) {
    			return true;
    		}
    	}
    	return false;
    }
}
