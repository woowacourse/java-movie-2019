import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.PlaySchedule;
import domain.Reservation;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	private static List<Reservation> reservations;
	private static final int MORE_BOOK = 2;

	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();

		int moreReservationFlag = MORE_BOOK;
		reservations = new ArrayList<>();
		while (moreReservationFlag == MORE_BOOK) {
			OutputView.printMovies(movies);
			addMovieSchedule();
			moreReservationFlag = InputView.inputMoreBookingFlag();
		}
		OutputView.printAllReservation(reservations);

		// 포인트 입력
		int point = InputView.inputPoint();
		int totalPrice = reservations.stream().mapToInt(Reservation::calculateEachMoviePrice).sum();
		Payment payment = new Payment(totalPrice, point);

		// 결제 방식 입력 & 최종금액 출력
		int paymentMethod = InputView.inputPaymentMethod();
		payment.setPaymentMethod(paymentMethod);
		payment.printFinalPrice();

		// 안내 message 출력
		OutputView.printBookingFinishMessage();
	}

	private static void addMovieSchedule() {
		int movieId = InputView.inputMovieId(reservations);
		Movie selectedMovie = MovieRepository.findMovie(movieId);
		OutputView.printMovie(selectedMovie);

		int startDateTime = InputView.inputStartDateTime(selectedMovie);
		PlaySchedule playSchedule = selectedMovie.getPlaySchedules().get(startDateTime - 1);
		OutputView.printPlaySchedule(playSchedule);

		int capacity = InputView.inputCapacity(playSchedule);
		reservations.add(new Reservation(selectedMovie, playSchedule, capacity));
	}
}
