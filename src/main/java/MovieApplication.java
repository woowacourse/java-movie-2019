import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
		OutputView.printMovies(movies);

		// 예약할 movie id 입력
		int movieId = InputView.inputMovieId();
		Movie selectedMovie = MovieRepository.findMovie(movieId);
		if (selectedMovie != null) {
			OutputView.printMovie(selectedMovie);
		}

		// 영화 시간표 선택
		// TODO selectedMovie.getPlaySchedules().size() 보다 작은 값
		int startDateTime = InputView.inputStartDateTime();
		PlaySchedule playSchedule = selectedMovie.getPlaySchedules().get(startDateTime - 1);
		OutputView.printPlaySchedule(selectedMovie, startDateTime);

		// 영화 인원 선택
		int capacity = InputView.inputCapacity();
		OutputView.printBookingResult(selectedMovie, playSchedule, capacity);

		// 결제
		// 포인트 입력
		int point = InputView.inputPoint();
		int totalPrice = selectedMovie.getTotalPrice(capacity);
		Payment payment = new Payment(totalPrice, point);

		// 결제 방식 입력 & 최종금액 출력
		int paymentMethod = InputView.inputPaymentMethod();
		payment.setPaymentMethod(paymentMethod);
		payment.printFinalPrice();

		// 안내 message 출력
		OutputView.printBookingFinishMessage();

	}
}
