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

	public String getMovieInfo() {
		return id + " - " + name + ", " + price + "원";
	}
	
	public int getId() {
		return id;
	}

	public void printMovieTimes() {
		for (PlaySchedule playSchedule : playSchedules) {
			System.out.print(playSchedule);
		}
	}

	public int getMovieCounts() {
		return playSchedules.size();
	}

	public PlaySchedule getPlaySchedule(int movieTimeNumber) {
		if (playSchedules.size() < movieTimeNumber)
			throw new IllegalArgumentException("해당 번호가 존재하지 않습니다.");
		return playSchedules.get(movieTimeNumber - 1);
	}
}
