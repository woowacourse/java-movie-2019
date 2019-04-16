package view;

import domain.*;
import utils.InputUtil;

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
        int point = getPoint();
        OneOrTwoToken isCredit = getIsCredit();
        System.out.println(allPay.getTotalCost(point, isCredit) + "입니다");
        System.out.println("예매 완료했습니다 ");
    }

    private static int getPoint() {
        try {
            return InputView.inputPoint();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPoint();
        }
    }

    private static OneOrTwoToken getIsCredit() {
        try {
            return InputView.getCreditOrCash();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getIsCredit();
        }
    }
}
