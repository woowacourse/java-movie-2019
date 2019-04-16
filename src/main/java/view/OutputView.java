package view;

import domain.Movie;
import domain.ReservedMovie;

import java.util.List;

public class OutputView {
    private static final String RESERVED_LIST = "예약 내역";
    private static final String RESULT_IS = "\n최종 결제한 금액은 ";
    private static final String IS_THIS = "입니다.";
    private static final String FINAL_COMMENT = "예매를 완료했습니다. 즐거운 영화 관람되세요.";


    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovies(Movie movie) {
        System.out.println(movie);
    }

    public static void printReservedMovies(List<ReservedMovie> reservedMovies) {
        System.out.println(RESERVED_LIST);
        for (ReservedMovie reservedMovie : reservedMovies
             ) {
            System.out.println(reservedMovie.toString());
            System.out.println();
        }
    }

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(RESULT_IS + purchaseAmount + IS_THIS);
        System.out.println(FINAL_COMMENT);

    }
}
