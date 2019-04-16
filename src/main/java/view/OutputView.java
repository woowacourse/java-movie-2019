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

    public static void printInputWrongMovieId() {
        System.out.println("없는 영화 아이디를 입력하셨습니다." + NEW_LINE);
    }

    public static void printErrorMessage() {
        System.out.println("티켓을 구매 할 수 없습니다." + NEW_LINE);
    }

    public static void printInputWrongSchedule() {
        System.out.println("잘못된 스케쥴을 입력하셨습니다." + NEW_LINE);
    }

    public static void printAlreadyStarted() {
        System.out.println("이미 영화가 시작했습니다." + NEW_LINE);
    }

    public static void printOutOfOneHour() {
        System.out.println("이미 예약하신 영화와 한 시간 밖의 범위에 있습니다." + NEW_LINE);
    }

    public static void printOverCapacity() {
        System.out.println("예약 가능 인원 범위에 맞지 않습니다." + NEW_LINE);
    }

    public static void printInputWrongPoint() {
        System.out.println("포인트는 음수가 될 수 없습니다." + NEW_LINE);
    }

    public static void printInputWrongMethod() {
        System.out.println("잘못된 결제 수단 값을 입력하셨습니다." + NEW_LINE);
    }
}
