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
		return this.id;
	}

	public boolean hasId(int id) {
		return (this.id == id ? true : false);
	}

	public boolean isValidTime(int time) {
		if (0 < time && time <= playSchedules.size()) {
			return true;
		}
		return false;
	}

	public boolean isValidPeople(int timeIndex, int people) {
		return playSchedules.get(timeIndex - 1).isValidPeopleCount(people);
	}

	void addPlaySchedule(PlaySchedule playSchedule) {
		playSchedules.add(playSchedule);
	}

	public String getMovieInfoString() {
		return id + " - " + name + ", " + price + "원";
	}
	
	public String getMovieTime(int timeIndex) {
		return playSchedules.get(timeIndex - 1).getMovieTime();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (PlaySchedule playSchedule : playSchedules) {
			sb.append(playSchedule);
		}
		return id + " - " + name + ", " + price + "원" + NEW_LINE + sb.toString();
	}
}
