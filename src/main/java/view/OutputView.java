package view;

import domain.Movie;
import domain.MovieReservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservations(List<MovieReservation> reservations) {
        System.out.println("예약 내역");

        for (MovieReservation reservation : reservations) {
            System.out.println(reservation + "\n");
        }
    }

    public static void printFinalPrice(double finalPrice) {
        System.out.println(String.format("\n최종 결제 금액은 %.0f 입니다.", finalPrice));
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
