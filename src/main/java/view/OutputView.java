package view;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationCategory;

import java.util.InputMismatchException;
import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie printChoiceMovies(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                System.out.println(movie);
                return movie;
            }
        }
        return hasNotMovie(movies);
    }

    private static Movie hasNotMovie(List<Movie> movies) {
        System.out.println("\n상영 목록 영화가 없습니다. 다시 입력해 주세요.");
        return printChoiceMovies(movies);
    }

    public static boolean printReservedCategory(List<ReservationCategory> reservationCategories, int isPayment) {
        if (isPayment == 1) {
            for (ReservationCategory reservationCategory : reservationCategories) {
                System.out.println(reservationCategory);
            }
            progressPayment(reservationCategories);
            return false;
        }

        return true;

    }

    private static void progressPayment(List<ReservationCategory> reservationCategories) {
        System.out.println("## 결제를 진행합니다.");
        int price = 0;
        for (ReservationCategory reservationCategory : reservationCategories) {
            price += reservationCategory.reservedPrice();
        }

        price = salePrice(price);
        System.out.println("\n최종 결제한 금액은 " + price + "원 입니다.\n" +
                "예매를 완료했습니다. 즐거운 영화 관람되세요.\n");
    }

    private static int salePrice(int price) {
        int point = InputView.inputPoint();
        int payWay = InputView.inputPayWay();
        price = price - point;
        if (payWay == 1) {
            price = price - (int) (price * 0.05);
        }
        if (payWay == 2) {
            price = price - (int) (price * 0.02);
        }
        return price;
    }

}
