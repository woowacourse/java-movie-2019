package view;

import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printNotExistedMovie() {
        System.out.println("※ 상영목록에 해당 영화는 존재하지 않습니다. 다시 선택해주세요.");
    }

    public static void printNotExistedSchedule() {
        System.out.println("※ 선택하신 영화에 해당 스케줄은 존재하지 않습니다. 다시 선택해주세요.");
    }

    public static void printExceededCapacity() {
        System.out.println("※ 예매 가능한 인원이 아닙니다. 인원 수를 다시 입력해주세요.");
    }

    public static void printReservation(List<Reservation> reservations) {
        System.out.println("예약 내역");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
