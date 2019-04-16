package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }
    
    public static int inputMovieTime() {
    	System.out.println("## 예약할 시간표를 선택하세요.(첫 번째 상영 시간이 1번)" );
    	return scanner.nextInt();
    }
    
    public static int inputMovieViewNum() {
    	System.out.println("## 예약할 인원을 입력하세요.");
    	return scanner.nextInt();
    }
    
    public static int inputPoint() {
    	System.out.println("## 결제를 진행합니다.");
    	System.out.println("포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
    	return scanner.nextInt();
    }
}
