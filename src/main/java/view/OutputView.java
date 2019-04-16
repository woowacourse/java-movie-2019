package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printPlaySchedule(Movie movie) {
        System.out.println(movie);
    }

    public static void printPayResult(AllPay allPay) {
        System.out.print("최종 결제 금액은");
        int point = InputView.inputPoint();
        int isCredit = InputView.getCreditOrCash();
        System.out.println(allPay.getTotalCost(point, isCredit) + "입니다");
        System.out.println("예매 완료했습니다 ");
    }
}
