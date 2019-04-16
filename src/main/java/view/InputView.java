package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("영화 아이디는 숫자입니다.");
            return inputMovieId();
        }
    }

    public static int inputMovieSchedule() {
        System.out.println("##예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("영화 시간은 숫자를 입력하여 선택하세요");
            return inputMovieSchedule();
        }
    }

    public static int inputMovieWatcher() {
        System.out.println("##예약할 인원을 입력하세요.");
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("예약 인원은 숫자를 입력하세요");
            return inputMovieWatcher();
        }
    }
}
