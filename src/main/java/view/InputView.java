package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String NOT_INPUT_INTEGER = "숫자가 아닌 데이터를 입력했습니다. 다시 입력해주세요." ;
    public static final String NOT_MOVIE_ID = "상영목록에 없는 영화입니다. 다시 입력해주세요.";
    public static final String NOT_MOVIE_SCHEDULE = "이미 상영시간이 지난 영화입니다. 다시 입력해주세요";
    public static final String OVER_RANGE_SCHEUDLE = "해당 상영시간은 존재하지 않는 상영시간입니다. 다시 입력해주세요";
    public static final String OVER_RANGE_CAPACITY = "예약 인원을 초가했습니다. 다시 입력해주세요";
    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return scanner.nextInt();
        } catch(InputMismatchException ex){
            System.out.println(NOT_INPUT_INTEGER);
            scanner.nextLine();
            return inputMovieId();
        }
    }
    public static int inputScheduleId() {
        try {
            System.out.println("##예약할시간표를선택하세요. ( 첫번째 상영시간이 1번) ");
            return scanner.nextInt();
        } catch(InputMismatchException ex){
            System.out.println(NOT_INPUT_INTEGER);
            scanner.nextLine();
            return inputScheduleId();
        }
    }
    public static int inputPerson(){
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            return scanner.nextInt();
        } catch(InputMismatchException ex){
            System.out.println(NOT_INPUT_INTEGER);
            scanner.nextLine();
            return inputPerson();
        }
    }
    //##예약을종료하고결제를진행하려면1번,추가예약을진행하려면2번
    public static int inputContinue(){
        try {
            System.out.println("##예약을 종료하고 결제를 진행하려면 1번, 추가예약을 진행하려면 2번");
            return scanner.nextInt();
        } catch(InputMismatchException ex){
            System.out.println(NOT_INPUT_INTEGER);
            scanner.nextLine();
            return inputContinue();
        }
    }
}
