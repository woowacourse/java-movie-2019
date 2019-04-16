package view;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationMovieList;

import java.util.List;

public class OutputView {
    private static final String RESULT_TOTAL_PRICE_FIRST = "최종 결제한 금액은 ";
    private static final String RESULT_TOTAL_PRICE_SECOND = "원 입니다.";
    private static final String END_MESSAGE = "예매를 완료했습니다. 즐거운 영화 관람되세요";
    private static final String ALL_MOVIE_LIST = "상영 영화 목록";

    public static void printMovies(List<Movie> movies) {
        System.out.println(ALL_MOVIE_LIST);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(int movieId) {
        System.out.println(MovieRepository.getSelectedMovie(movieId));
    }

    public static void printReservation() {
        System.out.println(ReservationMovieList.getInstance());
    }

    public static void printEndReservation(int totalPrice) {
        System.out.println(RESULT_TOTAL_PRICE_FIRST + totalPrice + RESULT_TOTAL_PRICE_SECOND);
        System.out.println(END_MESSAGE);
    }
}
