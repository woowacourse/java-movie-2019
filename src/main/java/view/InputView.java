package view;

import domain.Movie;
import domain.PlaySchedule;
import reservation.MovieReservation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return MovieReservation.checkExistList(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputMovieId();
        }
    }

    public static PlaySchedule inputPlaySchedule(Movie selectedMovie) {
        try {
            System.out.println("예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
            return MovieReservation.checkExistSchedule(selectedMovie,
                    Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputPlaySchedule(selectedMovie);
        }
    }

    public static int inputReservationPeople(PlaySchedule schedule) {
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            return schedule.checkValidReservation(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputReservationPeople(schedule);
        }
    }

    public static boolean InputContinueReservation() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            return chekcContinue(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return InputContinueReservation();
        }
    }

    private static boolean chekcContinue(int userInput){
        if(userInput == 1){
            return false;
        }
        if(userInput == 2){
            return true;
        }
        throw new IllegalArgumentException();
    }
}
