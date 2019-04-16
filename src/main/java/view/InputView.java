package view;

import domain.Movie;
import domain.MovieRepository;
import utils.CheckValidity;

import java.util.Scanner;

public class InputView extends CheckValidity {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        String movieId;
        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            movieId = scanner.next();
        } while (!validityMovieId(movieId));
        return Integer.parseInt(movieId);
    }

    private static boolean validityMovieId(String movieId) {
        return checkValidityIntegerFormat(movieId)
                && checkIsContainOfMovies(MovieRepository.getMovieIds(), Integer.parseInt(movieId));
    }

    public static int inputReservationTime(Movie movie) {
        String reservationTime;
        do {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 사영 시간이 1번)");
            reservationTime = scanner.next();
        } while (!validityReservationTime(movie, reservationTime));
        return Integer.parseInt(reservationTime);
    }

    private static boolean validityReservationTime(Movie movie, String reservationTime) {
        return checkValidityIntegerFormat(reservationTime)
                && checkIsContainOfReservationTime(movie, Integer.parseInt(reservationTime));
    }
}
