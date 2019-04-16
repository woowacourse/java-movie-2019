package view;

import domain.Movie;
import utils.InputCheckUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId(List<Movie> movies) {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            int input =inputInt();
            InputCheckUtils.checkInputReservationMoive(input, movies);
            return input;
        }catch(Exception e){
            System.err.println(e);
            return inputMovieId(movies);
        }
    }

    public static int inputInt(){
        try {
            return scanner.nextInt();
        }catch(InputMismatchException e){
            scanner.nextLine();
            System.err.println("입력 형식 오류");
            return inputInt();
        }
    }
}
