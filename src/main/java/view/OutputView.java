package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;

import java.util.List;

public class OutputView {
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private static final double CREDIT_CARD_DISCOUNT_RATE = 0.95;
    private static final double CASH_DISCOUNT_RATE = 0.98;

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printSelectMovie(int movieId) {
        System.out.println(MovieRepository.getMovieForMovieId(movieId));
        System.out.println();
    }

    public static void printReservation(List<MovieReservation> reservationList) {
        System.out.println("예약 내역");
        for (MovieReservation movieReservation : reservationList) {
            System.out.println(movieReservation);
        }
    }

    public static void printResultPay(int point, int payWith, List<MovieReservation> reservationList) {
        int price = 0;
        for (MovieReservation reservation : reservationList) {
            price += reservation.getPriceOfReservation();
        }
        price = price - point;
        if (payWith == CREDIT_CARD) {
            price = (int) Math.ceil(price * CREDIT_CARD_DISCOUNT_RATE);
        }
        if (payWith == CASH) {
            price = (int) Math.ceil(price * CASH_DISCOUNT_RATE);
        }
        System.out.println("최종 결제한 금액은 " + price + "원 입니다." );
        System.out.println("예매를 완료했습니다.즐거운 영화 관람되세요.");
    }
}
