package view;

import domain.Movie;
import domain.PurchasedMovie;
import utils.DateTimeUtils;

import java.util.Scanner;
import java.util.List;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int COUNT_OF_MOVIES = 8;
    private static final int COUNT_OF_SCHEDULES = 5;
    private static final int MIN_NUM = 1;

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");

        int moviedID = scanner.nextInt();

        if (moviedID < MIN_NUM || moviedID > COUNT_OF_MOVIES) {
            System.out.println("!! 없는 영화 입니다.");
            return inputMovieId();
        }

        return moviedID;
    }

    public static int inputMovieSchedule(List<Movie> movies, int movieId, List<PurchasedMovie> purchasedMovies) {
        System.out.println("## 예약할 시간표를 입력하세요. (첫번째 상영이 1번)");
        int scheduleNumber = scanner.nextInt();

        while (scheduleNumberCheck(scheduleNumber)) {
            return inputMovieSchedule(movies, movieId, purchasedMovies);
        }
        if(purchasedMovies.size() == 0) {
            return scheduleNumber;
        }
        while (scheduleGapCheck(purchasedMovies.get(0), movies.get(movieId), scheduleNumber)) {
            return inputMovieSchedule(movies, movieId, purchasedMovies);
        }
        return scheduleNumber;
    }

    private static boolean scheduleNumberCheck(int scheduleNumber) {
        if(scheduleNumber < MIN_NUM || scheduleNumber > COUNT_OF_SCHEDULES) {
            System.out.println("!! 없는 스케쥴 입니다.");
            return true;
        }
        return false;
    }

    private static boolean scheduleGapCheck(PurchasedMovie purchasedMovie, Movie movie, int scheduleNumber) {
        if (DateTimeUtils.isOneHourWithinRange(purchasedMovie.getLocalDateTime(),
                movie.getSchedule(scheduleNumber).getStartDateTime())) {
            System.out.println("!! 1시간 이상 차이가 납니다.");
            return true;
        }
        return false;
    }

    public static int inputCountOfTickets(List<Movie> movies, int movieId, int scheduleNumber) {
        System.out.println("## 예약할 인원을 입력하세요.");
        int countOfTickets = scanner.nextInt();

        while (checkCountOfTickets(countOfTickets)) {
            return inputCountOfTickets(movies, movieId, scheduleNumber);
        }
        while (checkCountOfCapacity(movies.get(movieId), scheduleNumber, countOfTickets)) {
            return inputCountOfTickets(movies, movieId, scheduleNumber);
        }
        return countOfTickets;
    }

    private static boolean checkCountOfTickets(int countOfTickets) {
        if (countOfTickets < MIN_NUM) {
            System.out.println("!! 1명 이상을 입력하세요.");
            return true;
        }
        return false;
    }

    private static boolean checkCountOfCapacity(Movie movie, int scheduleNumber, int countOfTickets) {
        if(!(movie.checkPossibleTickets(scheduleNumber, countOfTickets))) {
            System.out.println("!! 인원이 너무 많습니다");
            return true;
        }
        return false;
    }

    public static boolean inputContinueBooking() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2");
        int input = scanner.nextInt();

        while (input != 1 && input != 2) {
            return inputContinueBooking();
        }

        if (input == 1) {
            return false;
        }
        return true;
    }
}
