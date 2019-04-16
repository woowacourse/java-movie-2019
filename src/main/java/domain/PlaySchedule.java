package domain;

import static utils.DateTimeUtils.*;

import java.time.LocalDateTime;

import utils.DateTimeUtils;

public class PlaySchedule {
	private final LocalDateTime startDateTime;
	private int capacity;

	public PlaySchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}

	public boolean isValidGap(LocalDateTime userDateTime) {
		return DateTimeUtils.isOneHourWithinRange(startDateTime, userDateTime);
	}

	public boolean isValidPeopleCount(int peopleCount) {
		if (0 < peopleCount && peopleCount <= capacity) {
			return true;
		}
		return false;
	}
	
	public String getMovieTime() {
		return format(startDateTime);
	}
	
	@Override
	public String toString() {
		return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
