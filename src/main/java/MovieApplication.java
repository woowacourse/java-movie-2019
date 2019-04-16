import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);
		int curPoint = 0;
		while (true) {

			int movieId = InputView.inputMovieId();

			// TODO 구현 진행
			List<Payment> payMentList = new ArrayList<>();
			Payment payMent = null;

			/* 입력 받은 영화를 추가한다. */
			for (int i = 0; i < movies.size(); i++) {
				if (movieId == movies.get(i).getId()) {
					payMent = new Payment(movies.get(i));
					break;
				}
			}

			/* ## 예약할 시간표를 선택하세요." 메세지 출력, 예약할 시간표를 입력받는다. */
			int scheduleId = InputView.inputScheduleId();
			int reserveMenCount = InputView.inputreserveMenCount();
			int reserveEndorContinue = InputView.inputreserveEndorContinue();

			/* 결제를 진행한다 */
			if (reserveEndorContinue == 1) {
				payMent.setReserveMenCount(reserveMenCount);
				payMent.setScheduleId(scheduleId);
				payMent.printPayment();
				payMentList.add(payMent);

				int usePoint = InputView.inputuserPoint(curPoint);
				int cardORcash = InputView.inputCardOrCash();

				/* 최종금액 계산 */
				calcTotalpayment(cardORcash);
			}

			/* 2번을 선택할 경우 추가 예약이 진행 되도록 사이클 */
			continue;

		}

	}
}
