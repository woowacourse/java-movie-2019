package view;

import domain.Movie;
import domain.ReserveMovie;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTimetable(Movie currentMovie) {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영시간이 1번)");
        int movieTimeTable = scanner.nextInt() - 1;
        if (currentMovie.getPlaySchedules().get(movieTimeTable).isOverStartTime()) {
            System.out.println("상영 시간이 지났습니다. 다시 선택 해 주세요.");
            return inputTimetable(currentMovie);
        }
        return movieTimeTable;
    }

    public static int inputNumOfPerson(Movie currentMovie, int movieTimeTable) {
        System.out.println("## 예약할 인원을 입력하세요.");
        int movieNumOfPerson = scanner.nextInt();
        if (currentMovie.getPlaySchedules().get(movieTimeTable).isOverCapacity(movieNumOfPerson)) {
            System.out.println("예매 가능 인원을 초과합니다. 다시 선택 해 주세요.");
            return inputNumOfPerson(currentMovie, movieTimeTable);
        }
        return movieNumOfPerson;
    }

    public static boolean inputAdditionalTicketing() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번)");
        return (scanner.nextInt() == 2);
    }

    public static int inputPayment() {
        System.out.println("## 결제를 진행합니다.\n" +
                "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        int payment = scanner.nextInt();
        if (payment < 0) {
            System.out.println("음수 입력은 안됩니다. 다시 입력해 주세요.");
            return inputPayment();
        }
        return payment;
    }

    public static int inputCreditCard(List<ReserveMovie> reserveMovieList) {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int credit = scanner.nextInt();
        if (credit != 1 && credit != 2) {
            System.out.println("1 또는 2를 입력해 주세요.");
            return inputCreditCard(reserveMovieList);
        }
        return credit;
    }
}
