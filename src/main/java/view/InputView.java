package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * nextInt()를 했을때 기존에 입력했던 입력값을 Scanner가 그대로
     * input 값으로 받는 문제점이 있어 Scanner에서 한줄 띄우는 메서드
     */
    public static void makeLine(){
        scanner.nextLine();
    }

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

}
