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
		return id + " - " + name + ", " + price + "원" + NEW_LINE + sb.toString();
	}

	public boolean isId(int id) {
		return this.id == id;
	}
	
	public boolean isEnd(int scheduleNumber) {
		return playSchedules.get(scheduleNumber - 1).isEnd();
	}

	public boolean hasSchedule(int scheduleNumber) {
		return 1 <= scheduleNumber && scheduleNumber <= playSchedules.size();
	}

	public boolean hasEnoughCapacity(int scheduleNumber, int ticketCount) {
		return playSchedules.get(scheduleNumber - 1).hasEnoughCapacity(ticketCount);
	}
}
