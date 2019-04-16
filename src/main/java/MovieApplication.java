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
		int totalPayment = 0;
		List<Payment> payMentList = new ArrayList<>();
		Payment payMent = null;
		
		while (true) {

			int movieId = InputView.inputMovieId();
			
			if ( !checkMovieList(movies, movieId)) continue;
			
			payMent = new Payment(searchMovieList(movies, movieId));
			
			/* ## 예약할 시간표를 선택하세요." 메세지 출력, 예약할 시간표를 입력받는다. */
			//if ( !checkinputScheduleId()) continue;
			
			int scheduleId = InputView.inputScheduleId();
			int reserveMenCount = InputView.inputreserveMenCount();
			int reserveEndorContinue = InputView.inputreserveEndorContinue();
			totalPayment += payMent.getMovie().getPrice()*reserveMenCount;

			/* 결제를 진행한다 */
			if (reserveEndorContinue == 1) {
				
				payMent.setReserveMenCount(reserveMenCount);
				payMent.setScheduleId(scheduleId);
				payMent.printPayment();
				payMentList.add(payMent);

				int usePoint = InputView.inputuserPoint(curPoint);
				totalPayment -= usePoint;
				int cardORcash = InputView.inputCardOrCash();

				/* 최종금액 계산 */
				totalPayment = calcTotalpayment(totalPayment, cardORcash);
				System.out.println("최종 결제한 금액은"+totalPayment+"원 입니다.");
				System.out.println("예매를 완료했습니다. 즐거운 영화관람되세요.");
				break;
			}

			/* 2번을 선택할 경우 추가 예약이 진행 되도록 사이클 */
			continue;

		}

	}

	private static boolean checkinputScheduleId() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkMovieList(List<Movie> movies, int movieId) {
		/* 입력 받은 영화를 추가한다. */
		for (int i = 0; i < movies.size(); i++) {
			if (movieId == movies.get(i).getId()) {
				return true;
			}
		}
		
		System.out.println("해당 영화가 목록에 없습니다. 다시 입력 하세요.");
		
		return false;
	}

	private static  Movie searchMovieList(List<Movie> movies, int movieId) {
		/* 입력 받은 영화를 추가한다. */
		for (int i = 0; i < movies.size(); i++) {
			if (movieId == movies.get(i).getId()) {
				return movies.get(i);
			}
		}
		
		return null;
	}

	private static int calcTotalpayment(int totalPayment, int cardORcash) {

		/* 신용카드 */
		int sale = 0;
		if (cardORcash == 1) {
			sale = (int) (totalPayment * 0.05);
			return totalPayment -= sale;
		}

		sale = (int) (totalPayment * 0.02);
		return totalPayment -= sale;

	}
}
