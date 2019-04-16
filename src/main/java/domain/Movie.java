package domain;

import utils.NaturalNumber;

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

    public List<PlaySchedule> getPlaySchedules() {
        return this.playSchedules;
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public PlaySchedule getPlaySchedule(NaturalNumber index) {
    	if (index.toArrayIndex() >= playSchedules.size()) {
    		throw new IllegalArgumentException("존재하지 않은 영화시간 입니다.");
	    }
        return playSchedules.get(index.toArrayIndex());
    }

    public String printSummary() {
	    return id + " - " + name + ", " + price + "원" + NEW_LINE;
    }

    public int calPrice(int noOfPerson) {
    	return noOfPerson * price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return printSummary() + sb.toString();
    }
}
