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

import view.InputView;
import view.OutputView;

/**
 * 예매를 담당하는 객체
 * 
 * @author wongeunsong
 *
 */
public class TicketingManager {
	public void ticketing() {
		try {
			int movieId = InputView.inputMovieId();
			checkMovie(movieId);
			OutputView.printMovie(movieId);
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
}
