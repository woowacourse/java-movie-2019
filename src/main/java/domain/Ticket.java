/*
 * Ticket
 * 
 * version 1.0
 * 
 * 2019. 4. 16
 * 
 * Created by Wongeun Song
 */
package domain;

import java.time.LocalDateTime;

import utils.DateTimeUtils;

public class Ticket {
	private int movieId;
	private int scheduleNumber;
	private int count;
	private LocalDateTime startDateTime;
	
	public Ticket(int movieId, int scheduleNumber, int count) {
		this.movieId = movieId;
		this.scheduleNumber = scheduleNumber;
		this.count = count;
		this.startDateTime = MovieRepository.getStartDateTime(movieId, scheduleNumber);
	}
	
	public void checkOneHourWithinRange(LocalDateTime dateTime) throws IllegalArgumentException {
		if (!DateTimeUtils.isOneHourWithinRange(startDateTime, dateTime)) {
			throw new IllegalArgumentException("기존 예매 영화와 시간 차이가 1시간 이상입니다.");
		}
	}
}
