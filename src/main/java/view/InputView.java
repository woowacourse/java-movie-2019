package view;

import domain.Movie;
import error.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        String userInput = scanner.nextLine().trim();
        if (!Validator.isInteger(userInput)) {
            return inputMovieId();
        }
        int movieNumber = Integer.parseInt(userInput);
        if (!Validator.isMovieExist(movieNumber) ||
                !Validator.isMovieHasVacancy(movieNumber)) {
            return inputMovieId();
        }
        return movieNumber;
    }

    public static int inputScheduleIndex(int movieId){
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        String userInput = scanner.nextLine().trim();
        // 정수 체크
        if (!Validator.isInteger(userInput)) {
            return inputScheduleIndex(movieId);
        }
        // 스캐줄 존재하는지
        int scheduleIndex = Integer.parseInt(userInput)-1;
        if(!Validator.isScheduleExist(movieId, scheduleIndex)){
            return inputScheduleIndex(movieId);
        }
        // 스캐줄 공석이 있는지
        if(!Validator.isScheduleHaveVacancy(movieId, scheduleIndex)){
            return inputScheduleIndex(movieId);
        }
        return scheduleIndex;
    }

    public static int inputReservePersonCount(int movieId, int scheduleIndex) {
        System.out.println("예약할 인원을 입력하세요");
        String userInput = scanner.nextLine().trim();
        // 정수 체크
        if (!Validator.isInteger(userInput)) {
            return inputReservePersonCount(movieId, scheduleIndex);
        }
        // 해당스캐줄 해당인원으로 예약 가능한지
        int personCount = Integer.parseInt(userInput);
        if(!Validator.isScheduleReservePossible(movieId, scheduleIndex, personCount)){
            return inputReservePersonCount(movieId, scheduleIndex);
        }
        return personCount;
    }
}
