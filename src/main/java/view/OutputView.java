package view;

import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservations(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

    public static void printReceipt(List<Reservation> reservations, int point) {
        int totalPrice = 0;
        for (Reservation reservation : reservations)
            totalPrice += reservation.getPricePerReservation();
        System.out.println(NEW_LINE + "## 최종 결제한 금액은 " + (totalPrice - point) + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
