package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return scanner.nextInt();
        } catch(InputMismatchException ex){
            System.out.println("숫자가 아닌 데이터를 입력했습니다. 다시 입력해주세요.");
            scanner.nextLine();
            return inputMovieId();
        }
    }
}
