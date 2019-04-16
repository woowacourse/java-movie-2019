package view;

import domain.Movie;
import domain.PaymentInfo;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            printMovie(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printPayments(List<PaymentInfo> paymentInfos) {
        for (PaymentInfo paymentInfo : paymentInfos) {
            System.out.println(paymentInfo.getMovie().movieInfo());
            System.out.println(paymentInfo.getPlaySchedule().getStartDateTime());
            System.out.println("예약 인원:" + paymentInfo.getCountOfUser() + "\n");
        }
    }

    public static void printPayResult(int money) {
        System.out.println("최종 결제한 금액은 " + money + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
    public static void overUser(){
        System.out.println("구매 가능한 티켓수가 초과 하였습니다.");
    }
}
