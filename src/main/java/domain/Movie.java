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

	public boolean equalsId(int id) {
		return (this.id == id);
	}
	
	public boolean bookable(int schedule) {
		return (this.playSchedules.size() >= schedule);
	}
	
	public boolean isBeforeBegging(int schedule) {
		return this.playSchedules.get(schedule - 1).isBeforeBeginning();
	}
	
	public boolean bookable(int schedule, int numOfAudience) {
		return (this.playSchedules.get(schedule - 1).capable(numOfAudience));
	}
	
	public String getMovieInformation() {
		return id + " - " + name + ", " + price + "원" + NEW_LINE;
	}
	
	public String getPlayScheduleInformation(int schedule) {
		return playSchedules.get(schedule - 1).getPlayScheduleInformation();
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
		return getMovieInformation() + sb.toString();
	}
}
