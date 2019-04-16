package view;

import domain.Movie;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printPayInfo(Map<Movie, Integer> movies) {
        System.out.println("예약 내역");
        for (Movie movie : movies.keySet()) {
            System.out.println(movie.toString());
            System.out.println("예약 인원 : " + movies.get(movie) + "명");
        }
        System.out.println("## 결제를 진행합니다.");
    }

    public static void printPayResult(int money) {
        String payMoneyInfo = "최종 결제한 금액은 ";
        System.out.println(payMoneyInfo + money);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람 되세요.");
    }

}
