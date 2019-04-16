package domain;

import java.util.InputMismatchException;

import view.InputView;
import view.OutputView;

public class MovieApplication {
	public static void main(String[] args) {
		OutputView.printMovies(MovieRepository.getMovies());
		
		do {
			MovieReservation.reserveMovie();
		} while(InputView.inputContinueReservation() == 2);
		OutputView.printReservationHistories();
		// 결제 진행을 구현해야합니다.
		
	}
}
