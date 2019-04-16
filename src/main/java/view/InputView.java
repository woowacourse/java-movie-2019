package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try{
            System.out.println("\n## 예약할 영화를 선택하세요.");
            int input = Integer.parseInt(scanner.nextLine());
            return checkInputMinusId(input);
        }catch(InputMismatchException | IllegalArgumentException e){
            System.out.println("\n잘못 입력하였습니다. 다시입력해 주세요.");
            return inputMovieId();
        }
    }

    private static int checkInputMinusId(int input){
        if(input < 0){
            System.out.println("\n음수가 입력되었습니다. 다시입력해주세요.");
            return inputMovieId();
        }
        return input;
    }

    public static int inputChoiceTime(){
        try{
            System.out.println("\n## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            int input = Integer.parseInt(scanner.nextLine());
            return checkInputMinusTime(input);
        } catch(InputMismatchException | IllegalArgumentException e){
            System.out.println("\n잘못 입력하였습니다. 다시입력해 주세요.");
            return inputChoiceTime();
        }
    }

    private static int checkInputMinusTime(int input){
        if(input < 0){
            System.out.println("\n음수가 입력되었습니다. 다시입력해주세요.");
            return inputChoiceTime();
        }
        return input;
    }

    public static int inputReservedPerson(){
        try{
            System.out.println("\n## 예약할 인원을 입력하세요.");
            int input = Integer.parseInt(scanner.nextLine());
            return checkInputMinusPerson(input);
        } catch(InputMismatchException | IllegalArgumentException e){
            System.out.println("\n잘못 입력하였습니다. 다시입력해 주세요.");
            return inputReservedPerson();
        }
    }

    private static int checkInputMinusPerson(int input){
        if(input < 0){
            System.out.println("\n음수가 입력되었습니다. 다시입력해주세요.");
            return inputReservedPerson();
        }
        return input;
    }

    public static int inputIsPayment(){
        System.out.println("\n## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return scanner.nextInt();
    }

    public static int inputPoint(){
        System.out.println("\n## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        return scanner.nextInt();
    }

    public static int inputPayWay(){
        System.out.println("\n## 신용카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }

}
