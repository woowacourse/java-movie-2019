package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf("최종결제한금액은 %d 원입니다.\n", totalPrice);
        System.out.println("예매를완료했습니다.즐거운영화관람되세요");
    }
}
