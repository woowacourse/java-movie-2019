package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;
    private final int idxMinus = 1;
    private PlaySchedule playSchedule;
    private int people;
    

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
    
    public String toStringPurchaseInfo() {
		return id + " - " + name + ", " + price + "원" + NEW_LINE
                + playSchedule.toStringPurchaseInfo()
                + "예약 인원 : "+people+"명" + NEW_LINE;
    }
    
    public boolean isMovieId(int movieId) {
    	if (this.id == movieId) {
			return true;
		}
    	return false;
    }

    public boolean isValidSchedule(int movieScheduleId) {
    	playSchedule = 
    			playSchedules.get(movieScheduleId-idxMinus);
		if (playSchedule.isSchedule()) {
			return true;
		}
    	return false;
    }

    public boolean isValidCapacity(PlaySchedule playSchedule, int peopole) {
    	this.people = peopole;
    	if (playSchedule.isCapacity(peopole)) {
			return true;
		}
    	return false;
    }
    
    public PlaySchedule getPlaySchedule() {
		return playSchedule;
    }
    
    public int getPeople() {
    	return people;
    }

    public int getPrice() {
    	return price;
    }
}
