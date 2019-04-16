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
        System.out.println();
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

    public static void printReceipt(int totalPrice) {
        System.out.println(NEW_LINE + "## 최종 결제한 금액은 " + totalPrice + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    public static void printInputWrongValueMessage() {
        System.out.println("잘못된 값을 입력하셨습니다." + NEW_LINE);
    }

    public static void printErrorMessage() {
        System.out.println("티켓을 구매 할 수 없습니다." + NEW_LINE);
    }
}
