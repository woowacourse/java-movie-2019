package view;

import domain.Movie;

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

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPaymentBegin() {
        System.out.println("## 결제를 진행합니다.");
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println("최종 결제한 금액은 " + totalPrice + "원 입니다.");
        System.out.println("예매를 완료하였습니다. 즐거원 영화 관람 되세요.");
    }
}
