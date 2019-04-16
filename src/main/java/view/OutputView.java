package view;

import domain.Movie;
import domain.SelectMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printNotNumber (){
        System.out.println("올바른 숫자를 입력해 주세요.");
    }

    public static void printNotInMovieNum(){
        System.out.println("영화 목록 범위 안의 정수인 숫자를 입력해 주세요.");
    }

    public static void printSelectedMovie(Movie movie){
        System.out.println(movie);
    }

    public static void printNotInMovieTime(){
        System.out.println("예약 가능한 시간대의 영화번호를 선택해 주세요");
    }

    public static void printNotInPeopleNum(){
        System.out.println("0에서 가능한 예약 가능 인원 이내의 숫자를 입력해 주세요.");
    }

    public static void printNotZeroOne(){
        System.out.println("0 혹은 1을 입력해 주세요.");
    }

    public static void printTicketHistory(List<SelectMovie> movies){
        for (SelectMovie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void paymentRequest(){
        String paymentString = "## 결제를 진행합니다.";
        System.out.println(paymentString);
    }

    public static void pointOverPrice(){
        System.out.println("포인트가 구매 금액보다 높습니다");
    }

    public static void printResult(int money){
        System.out.format( "최종 결제한 금액은 %d원 입니다.%n", money);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    }
