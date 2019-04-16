package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
	private final LocalDateTime startDateTime;
	private int capacity;

	public PlaySchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public boolean isLessThanCapacity(int inputtedCapacity) {
		if(this.capacity <= inputtedCapacity) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
