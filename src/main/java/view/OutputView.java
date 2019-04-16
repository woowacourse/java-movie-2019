package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printPaymentStart(){
        System.out.println("결제를 시작합니다.");
    }

    public static void printTotalPrice(double price){
        System.out.println("총 금액은 : "+ price +"원 입니다.");
    }
}
