package view;

import domain.Movie;
import domain.MovieBookingInfo;
import domain.UserInfo;

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

    public static void printReservedMovieList(UserInfo user) {
        for (MovieBookingInfo bookingInfo : user.getBookingList()) {
            System.out.println(bookingInfo);
        }
    }

    public static void printReserveSuccess(int price) {
        System.out.println(String.format("최종 결제한 금액은 %d원 입니다.", price));
        System.out.println("예매를 완료했습니다. 즐거운 영화관람 되세요.");
    }
}
