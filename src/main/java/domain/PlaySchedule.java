package domain;

import static utils.DateTimeUtils.format;

import java.time.LocalDateTime;

import utils.DateTimeUtils;

public class PlaySchedule {
	private final LocalDateTime startDateTime;
	private int capacity;

	public PlaySchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	boolean isThereEnoughTicket(int numOfTicket) {
		return numOfTicket <= capacity;
	}

	void subtractCapacity(int numOfTicket) {
		if (!isThereEnoughTicket(numOfTicket))
			throw new IllegalArgumentException(capacity + " > " + numOfTicket + " : 남은 표보다 많이 파셨어요.");
		capacity -= numOfTicket;
	}

	int getCapacity() {
		return capacity;
	}

	boolean isWithInOneHour(PlaySchedule newSchedule) {
		return DateTimeUtils.isOneHourWithinRange(startDateTime, newSchedule.getStartDateTime());
	}

	public String getFirstLine() {
		return "시작시간: " + format(startDateTime) + "\n";
	}

	@Override
	public String toString() {
		return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
