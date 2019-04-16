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

	public int getId() {
		return id;
	}

	public int getTotalPrice(int capacity) {
		return price * capacity;
	}
	
	public String getMovieSummary() {
		return id + " - " + name + ", " + price + "원\n";
	}

	public List<PlaySchedule> getPlaySchedules() {
		return playSchedules;
	}
	
	public boolean isLessThanPlayScheduleSize(int capacity) {
		return (playSchedules.size() >= capacity) ? true : false;
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
}
