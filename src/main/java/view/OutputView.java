package view;

import domain.Movie;
import domain.MovieReservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("##상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservations(List<MovieReservation> movieReservations) {
        System.out.println("예약 내역");
        for (MovieReservation movieReservation : movieReservations) {
            System.out.println(movieReservation.toString());
        }
    }

    public static void printPaymentResult(int finalPrice) {
        if (finalPrice <= 0) {
            System.out.println("포인트로 모두 결제하였습니다.");
        }
        System.out.println(String.format("\n최종 결제한 금액은 %d원 입니다.", finalPrice));
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
