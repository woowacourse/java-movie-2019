package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printList() {
        System.out.println("## 상영 영화 목록");
    }
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void outputInforMationMovie() {
        System.out.println("예약 내역");
    }

    public static void outputPaymentStep() {
        System.out.println("## 결제를진행합니다");
    }

    public static void outputTotalPrice(int totalprice) {
        System.out.println("최종 결제한 금액은 "+totalprice +"원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요");
    }

}
