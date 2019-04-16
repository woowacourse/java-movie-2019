package view;

import domain.Movie;
import error.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLEASE_INPUT_AGAIN = "다시입력해주세요.";

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

    public static boolean inputWannaEndMovieChoice(){
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        String userInput = scanner.nextLine().trim();
        // 정수 체크
        if (!Validator.isInteger(userInput)) {
            return inputWannaEndMovieChoice();
        }
        // 1도 아니고 2도아닌지 체크
        int number = Integer.parseInt(userInput);
        if((number != 1) && (number != 2)){
            System.out.println(PLEASE_INPUT_AGAIN);
            return inputWannaEndMovieChoice();
        }
        return (number == 1) ? true : false;
    }

    public static boolean inputIsCardUse(){
        System.out.println("## 신용카드는 1번, 현금은 2번");
        String userInput = scanner.nextLine().trim();
        // 정수 체크
        if (!Validator.isInteger(userInput)) {
            return inputWannaEndMovieChoice();
        }
        // 1도 아니고 2도아닌지 체크
        int number = Integer.parseInt(userInput);
        if((number != 1) && (number != 2)){
            System.out.println(PLEASE_INPUT_AGAIN);
            return inputWannaEndMovieChoice();
        }
        return (number == 1) ? true : false;
    }

    public static int inputPoint(){
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        String userInput = scanner.nextLine().trim();
        // 정수 체크
        if (!Validator.isInteger(userInput)) {
            return inputPoint();
        }
        // 0이상인지 체크
        int point = Integer.parseInt(userInput);
        if(point < 0){
            System.out.println(PLEASE_INPUT_AGAIN);
            return inputPoint();
        }
        return point;
    }
}
