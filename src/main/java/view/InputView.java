package view;

import domain.PayDiscount;
import domain.ReservationCommand;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return inputNumber();
    }

    public static int inputMovieStartDateTimeIdx() {
        System.out.println("## 예약할시간표를선택하세요.(첫번째상영시간이1번)");
        return inputNumber();
    }

    public static int inputNumReserve() {
        System.out.println("## 예약할인원을입력하세요.");
        return inputNumber();
    }

    public static ReservationCommand inputReservationCommand() {
        System.out.println("##예약을종료하고결제를진행하려면1번,추가예약을진행하려면2번");
        int num = inputNumber();
        ReservationCommand command = ReservationCommand.valueOf(num);
        if (command == ReservationCommand.NOT_EXIST) {
            // TODO 애러 메세지 출력
            return inputReservationCommand();
        }
        return command;
    }

    public static int inputPoint() {
        System.out.println("##결제를진행합니다.");
        System.out.println("##포인트사용금액을입력하세요.포인트가없으면0입력");
        int point = inputNumber();

        return point;
    }

    public static PayDiscount inputPayDiscount() {
        System.out.println("##신용카드는1번,현금은2번");
        int command = inputNumber();
        PayDiscount discount = PayDiscount.valueOf(command);
        if (discount == PayDiscount.NOT_EXIST) {
            System.out.println("잘못된 번호입니다.");
            return inputPayDiscount();
        }
        return discount;
    }

    private static int inputNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            scanner.nextLine();
            System.out.println("잘못된 입력입니다.");
            return inputNumber();
        }
    }
}
