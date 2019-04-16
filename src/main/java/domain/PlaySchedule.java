package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
	private static final char NEW_LINE = '\n';

	private final LocalDateTime startDateTime;
	private int capacity;

	public PlaySchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}

	public boolean capable(int numOfAudience) {
		return capacity >= numOfAudience;
	}
	
	public boolean isBeforeBeginning() {
		return startDateTime.isAfter(LocalDateTime.now());
	}
	
	public String getPlayScheduleInformation() {
		return "시작시간: " + format(startDateTime) + NEW_LINE;
	}

	@Override
	public String toString() {
		return getPlayScheduleInformation() + " 예약가능인원: " + capacity + NEW_LINE;
	}
}
