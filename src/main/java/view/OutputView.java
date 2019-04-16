package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservationHistory(int movieId, int movieTime, int movieViewer) {
        System.out.println("예약 내역");
        for (Movie movie : MovieRepository.getMovies(movieId)) {
            System.out.println(movie.toString(movieTime));
        }
        System.out.println("예약 인원: " + movieViewer + "명");
    }

    public static int getTicketPrice(int movieId, int movieViewer) {
        return MovieRepository.getMovies(movieId).get(0).getPrice() * movieViewer;
    }

    public static void printPayment(int ticketPrice, int point, double discountRate) {
        System.out.println("최종 결제한 금액은 " + (int)((ticketPrice - point) * discountRate) + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

}
