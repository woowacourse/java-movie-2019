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

    public static int inputBookingTime(Movie movie) {
        String bookingTime;
        do {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 사영 시간이 1번)");
            bookingTime = scanner.next();
        } while (!validityBookingTime(movie, bookingTime));
        return Integer.parseInt(bookingTime);
    }

    private static boolean validityBookingTime(Movie movie, String bookingTime) {
        return checkValidityIntegerFormat(bookingTime)
                && checkIsContainOfBookingTime(movie, Integer.parseInt(bookingTime))
                && checkIsShowTimeBefore(movie, Integer.parseInt(bookingTime));
    }

    public static int inputBookingNumber(Movie movie, int bookingTime) {
        String bookingNumber;
        do {
            System.out.println("## 예약할 인원을 입력하세요.");
            bookingNumber = scanner.next();
        } while (!validityBookingNumber(movie, bookingTime, bookingNumber));
        return Integer.parseInt(bookingNumber);
    }

    private static boolean validityBookingNumber(Movie movie, int bookingTime, String bookingNumber){
        return checkValidityIntegerFormat(bookingNumber)
                && checkIsValidityBookingNumber(movie, bookingTime, Integer.parseInt(bookingNumber));
    }
}
