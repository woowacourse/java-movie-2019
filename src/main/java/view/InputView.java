package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try{
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요");
            return inputMovieId();
        }
    }
}
