package view;

import domain.Movie;
import domain.ReserveMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printHistory(List<ReserveMovie> reserveMovies) {
        for (ReserveMovie reserveMovie : reserveMovies) {
            System.out.println(reserveMovie);
        }
    }

    public static void printPayment(int totalPrice) {
        System.out.println("최종 결제한 금액은 " + totalPrice + "원 입니다.\n" +
                "예매를 완료했습니다. 즐거운 영화 관람되세요.\n");
    }
}
