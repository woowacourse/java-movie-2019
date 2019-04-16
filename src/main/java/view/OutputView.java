package view;

import domain.Movie;
import domain.MovieTicket;

import java.util.List;

public class OutputView {
	private static final char NEW_LINE = '\n';
	private static final String PRINT_MOVIES_MESSAGE = "## 상영 영화 목록";
	private static final String PRINT_RESERVATION_MESSAGE = "예약 내역";
	private static final String FINAL_PAYMENT_MESSAGE_PREFIX = "최종 결제한 금액은 ";
	private static final String FINAL_PAYMENT_MESSAGE_SUFFIX = "입니다." + NEW_LINE + "예매를 완료했습니다. 즐거운 영화 관람되세요.";

	public static void printMovies(List<Movie> movies) {
		System.out.println(PRINT_MOVIES_MESSAGE);
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printMovieTickets(List<MovieTicket> movieTickets) {
		System.out.println(PRINT_RESERVATION_MESSAGE);
		for (MovieTicket movieTicket : movieTickets) {
			System.out.println(movieTicket);
		}
	}

	public static void printFinalPrice(int price) {
		System.out.println(FINAL_PAYMENT_MESSAGE_PREFIX);
		System.out.println(price);
		System.out.println(FINAL_PAYMENT_MESSAGE_SUFFIX);
	}
}
