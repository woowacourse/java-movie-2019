package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }
    
    public static int inputSchedule() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }
    
    public static int inputNumOfPeople() {
        System.out.println("## 예약할 인원을 입력하세요.");
        return scanner.nextInt();
    }
    
    public static int inputCase(String massage) {
        System.out.println(massage);
        int ret = scanner.nextInt();
        if(ret != 1 && ret != 2) {
        	throw new IllegalArgumentException("잘못된 입력입니다. \n다시입력해주세요.");
        }
		return ret;
    }
    
    public static int inputRechoiceOrNot() {
    	return inputCase("## 예약을 종료하고 결재를 진행하려면 1번, 추가 예약을 진행하려면 2번을 입력하세요.");
    }
    
    public static int inputPoint() {
        System.out.println("## 포인트 사용 금액을 입력해주세요. 없으면 0을 입력해주세요.");
        return scanner.nextInt();
    }
}
