package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printPayment(int balance) {
        System.out.println("최종 결제한 금액은 " + balance + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
    }
}