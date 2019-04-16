package view;

import domain.Movie;
import domain.BookedMovie;

import java.util.List;

public class OutputView {
    private static final char NEW_LINE = '\n';

    public static void printMovies(List<Movie> movies) {
        System.out.println(NEW_LINE + "## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie selectedMovie) {
        System.out.println(selectedMovie);
    }

    public static void printBookedMovies(List<BookedMovie> bookedMovies) {
        System.out.println("예약 내역");
        for (BookedMovie b : bookedMovies) {
            b.printReservation();
        }
    }

    public static void printPaymentGuide() {
        System.out.println("## 결제를 진행합니다.");
    }

    public static void printPointExceededWarining(int totalCharge) {
        System.out.format("포인트 사용은 결제 금액 %d를 넘을 수 없습니다." + NEW_LINE, totalCharge);
    }

    public static void printReservationSummary(int finalCharge) {
        System.out.format("최종 결제한 금액은 %d 입니다." + NEW_LINE
                + "예약을 완료했습니다. 즐거운 관람 되세요.", finalCharge);
    }
}
