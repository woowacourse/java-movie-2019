package view;

import domain.BookingList;
import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printPlaySchedule(Movie selectedMovie) {
        System.out.println(selectedMovie);
    }

    public static void printBookingList(BookingList bookingList) {
        System.out.println("예약 내역");
        System.out.println(bookingList);
    }

    public static void printTotalPrice(int totalPrice) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("최종 결한 금액은 "+totalPrice+" 입니다.\n")
                .append("예매를 완료했습니다. 즐거 영화 관람되세요.");
        System.out.println(sb.toString());
    }
}
