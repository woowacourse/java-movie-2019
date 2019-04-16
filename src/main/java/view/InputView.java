package view;

import domain.PlaySchedule;
import domain.Movie;
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

    public static int inputMovieSchedule(List<Movie> movies, int movieId) {
        System.out.println("## 예약할 시간표를 입력하세요. (첫번째 상영이 1번)");

        int scheduleNumber = scanner.nextInt();

        while (scheduleNumber < MIN_NUM || scheduleNumber > COUNT_OF_SCHEDULES) {
            System.out.println("!! 없는 스케쥴 입니다.");
            return inputMovieSchedule(movies, movieId);
        }

        return scheduleNumber;
    }

    public static int inputCountOfTickets(List<Movie> movies, int movieId, int scheduleNumber) {
        System.out.println("## 예약할 인원을 입력하세요.");

        int countOfTickets = scanner.nextInt();

        while (countOfTickets < MIN_NUM) {
            System.out.println("!! 1명 이상을 입력하세요.");
            return inputCountOfTickets(movies, movieId, scheduleNumber);
        }

        while (movies.get(movieId).checkPossibleTickets(scheduleNumber, countOfTickets)) {
            System.out.println("!! 인원이 너무 많습니다.");
            return inputCountOfTickets(movies, movieId, scheduleNumber);
        }

        return countOfTickets;
    }

    public static boolean inputContinueBooking() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2");
        int input = scanner.nextInt();

        if(input == 1) {
            return false;
        }
        return true;
    }
}
