package view;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");
            scanner.next();
            return inputMovieId();
        }
    }

    public static int inputSchedule() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");
            scanner.next();
            return inputMovieId();
        }
    }

    public static int inputCapacity() {
        System.out.println("## 예약할 인원을 입력하세요.");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");
            scanner.next();
            return inputMovieId();
        }
    }

    public static int inputPayOrRepeatMenu() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주시기 바랍니다.");
            scanner.next();
            return inputMovieId();
        }
    }
}