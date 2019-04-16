package view;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_TIME_MENT = "## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)";
    private static final String INPUT_NUMBER_OF_PEOPLE_MENT = "## 예약할 인원을 입력하세요.";
    private static final String INPUT_PAY_OR_RESERVE_MENT = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String INPUT_ERROR_MENT = "입력 형식이 올바르지 않습니다.";
    private static final String INPUT_START_PAYMENT = "## 결제를 진행합니다.";
    private static final String INPUT_POINT_AMOUNT = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieTime() {
        try {
            System.out.println(INPUT_MOVIE_TIME_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }

    public static int inputNumberOfPeople() {
        try {
            System.out.println(INPUT_NUMBER_OF_PEOPLE_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }

    public static int inputPayOrReserve() {
        try {
            System.out.println(INPUT_PAY_OR_RESERVE_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }

    public static int inputPoint(){
        try{
            System.out.println(INPUT_START_PAYMENT);
            System.out.println(INPUT_POINT_AMOUNT);
            return scanner.nextInt();
        } catch (Exception e){
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }
}
