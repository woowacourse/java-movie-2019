package domain;

import java.util.List;

public class OutputView {

    public static void printList()
    { System.out.println("## 상영 영화 목록"); }

    public static void printMovies(List movies) {
        for (Movie movie : movies) { System.out.println(movie); } }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void outputPaymentStep() {
        System.out.println("## 결제를진행합니다");
    }

    public static void outputconfirm() {
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요");
    }
}
