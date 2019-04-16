package view;

import domain.Movie;
import domain.ReservationList;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printAMovie(Movie aMovie) {
        System.out.println(aMovie);
    }

    public static void printReserveList(ReservationList reservationList) {
        System.out.println("예매 내역");
        for (Movie movie : reservationList.getMovieSet()) {
            Integer movieTime       = reservationList.getTimeByMovie(movie);
            Integer reserveCount    = reservationList.getCountByMovie(movie);
            System.out.println(movie.toStringFromIdAndTime(movieTime, reserveCount));
        }
    }

    public static void printProcessMessage() {
        System.out.println("## 결제를 진행합니다.");
    }

    public static void printPayResult(int payAmount) {
        System.out.printf("최종 결제한 금액은 %d원 입니다.\n", payAmount);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
