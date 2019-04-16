package view;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationCategory;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie printChoiceMovies(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if(movie.getId() == movieId){
                System.out.println(movie);
                return movie;
            }
        }
        return null;
    }

    public static void printReservedCategory(List<ReservationCategory> reservationCategories, int isPayment){
        for(ReservationCategory reservationCategory : reservationCategories){
            System.out.println(reservationCategory);
        }
    }

    public static void progressPayment(List<ReservationCategory> reservationCategories){
        System.out.println("## 결제를 진행합니다.");
        int price = 0;
        for(ReservationCategory reservationCategory : reservationCategories){
            price += reservationCategory.reservedPrice();
        }

        int point = InputView.inputPoint();
        int payWay = InputView.inputPayWay();

        price = price - point;

        if(payWay == 1){
            price = price - (int)(price * 0.05);
        }
        if(payWay == 2){
            price = price - (int)(price * 0.02);
        }

        System.out.println("\n최종 결제한 금액은 "+ price +"원 입니다.\n" +
                "예매를 완료했습니다. 즐거운 영화 관람되세요.\n");

    }

//    private static Movie checkMovieId(Movie movie, int movieId) {
//        if (movie.getId() == movieId) {
//            System.out.println(movie);
//            return movie;
//        } else {
//            System.out.println("상영 목록에 영화가 없습니다. 다시 입력해 주세요.");
//            movieId = InputView.inputMovieId();
//            return checkMovieId(movie, movieId);
//        }
//    }
}
