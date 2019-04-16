/*
 * TicketingManager
 * 
 * version 1.0
 * 
 * 2019. 4. 16
 * 
 * Created by Wongeun Song
 */
package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

/**
 * 예매를 담당하는 객체
 * 
 * @author wongeunsong
 *
 */
public class TicketingManager {
	private List<Ticket> tickets;
	
	public void ticketing() {
		try {
			int movieId = InputView.inputMovieId();
			checkMovie(movieId);
			OutputView.printMovie(movieId);
			int scheduleNumber = InputView.inputScheduleNumber();
			checkSchedule(movieId, scheduleNumber);
			int ticketCount = InputView.inputTicketCount();
			checkTicketCount(movieId, scheduleNumber, ticketCount);
			tickets.add(new Ticket(movieId, scheduleNumber, ticketCount));
		} catch (Exception e) {
			OutputView.printErrorMessage(e);
			ticketing();
		}
	}

	private void checkMovie(int movieId) {
		if (!MovieRepository.hasMovie(movieId)) {
			throw new IllegalArgumentException("해당 영화는 상영중이지 않습니다.");
		}
	}

	private void checkSchedule(int movieId, int scheduleNumber) {
		if (!MovieRepository.hasSchedule(movieId, scheduleNumber)) {
			throw new IllegalArgumentException("해당 상영 시간은 존재하지 않습니다.");
		}
		if (MovieRepository.isEndSchedule(movieId, scheduleNumber)) {
			throw new IllegalArgumentException("상영 시작 시간이 이미 지났습니다.");
		}
	}
	
	private void checkTicketCount(int movieId, int scheduleNumber, int ticketCount) {
		if (!MovieRepository.hasEnoughCapacity(movieId, scheduleNumber, ticketCount)) {
			throw new IllegalArgumentException("자리가 부족합니다.");
		}
	}
	
}
