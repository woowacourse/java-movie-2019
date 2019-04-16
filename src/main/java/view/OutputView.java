package view;

import domain.Movie;
import domain.PlaySchedule;
import domain.Reservation;

import java.util.List;

public class OutputView {
    private static final String TITLE_MOVIES = "##상영영화목록";
    private static final String TITLE_RESERVATIONS = "예약내역";
    private static final String TITLE_PAYMENT = "##결제를진행합니다.";
    private static final String MESSAGE_PAYMENT_RESULT = "최종결제한금액은 %d 원입니다.\n" +
		    "예매를완료했습니다.즐거운영화관람되세요";

    public static void printMovies(List<Movie> movies) {
        System.out.println(TITLE_MOVIES);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printPlaySchedule(Movie movie) {
        System.out.print(movie.printSummary());
        for (PlaySchedule playSchedule : movie.getPlaySchedules()) {
            System.out.print(playSchedule.toString());
        }
    }

    public static void printResevations(List<Reservation> reservations) {
        System.out.println(TITLE_RESERVATIONS);
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void printStartPayment() {
		System.out.println(TITLE_PAYMENT);
    }

    public static void printPaymentResult(int price) {
    	System.out.println(String.format(MESSAGE_PAYMENT_RESULT, price));
    }
}
