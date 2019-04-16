package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try{
            System.out.println("## 예약할 영화를 선택하세요.");
            int movieId = scanner.nextInt();
            return  movieId;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return inputMovieId();
        }

    }
}
