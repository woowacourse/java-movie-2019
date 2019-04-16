package view;

import domain.Booking;
import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie, List<PlaySchedule> schedules) {
        System.out.println(movie);
        for (PlaySchedule schedule : schedules) {
            System.out.print(schedule);
        }
    }

    public static void printBookings(List<Booking> bookings) {
        System.out.println("예약 내역");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public static void printInvalidInput() {
        System.out.println("잘못된 입력입니다.");
    }

    public static void printFinished(int payed) {
        System.out.println(String.format("최종 결제한 금액은 %d원 입니다.", payed));
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    public static void printUnbookableSchedule() {
        System.out.println("예약할 수 없는 스케줄입니다.");
    }

    public static void printUnbookableTogether() {
        System.out.println("함께 예약할 수 없는 스케줄이 있습니다.");
        System.out.println("스케줄을 다시 선택합니다.");
    }
}
