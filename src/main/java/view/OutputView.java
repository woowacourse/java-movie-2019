package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printResult(int cashOrCredit, int price){
        int result = price;
        if(cashOrCredit == 1){
            result = (int)(result * 0.95);
        } else {
            result = (int)(result * 0.98);
        }
        System.out.println("최종 결제한 금액은 " + result + "원 입니다.\n" +
                "예매를 완료 했습니다. 즐거운 영화관람 되세요.");
    }
}
