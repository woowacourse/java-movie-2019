package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMovieId() {
        String scannedMovieId;
        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            scannedMovieId = SCANNER.nextLine();
        }
        while (!Validator.isNaturalNumber(scannedMovieId));
        return Integer.parseInt(scannedMovieId);
    }

    public static int inputMovieSchedule() {
        String scannedMovieSchedule;
        do {
            System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            scannedMovieSchedule = SCANNER.nextLine();
        }
        while (!Validator.isNaturalNumber(scannedMovieSchedule) || scannedMovieSchedule.equals("0"));
        return Integer.parseInt(scannedMovieSchedule) - 1;
    }

    public static int inputNumberOfPeople() {
        String scanned;
        do {
            System.out.println("## 예약할 인원을 입력하세요.");
            scanned = SCANNER.nextLine().trim();
        }
        while (!Validator.isNaturalNumber(scanned));
        return Integer.parseInt(scanned);
    }

    public static int inputContinue() {
        String scanned;
        do {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            scanned = SCANNER.nextLine().trim();
        }
        while (!scanned.equals("1") && !scanned.equals("2"));
        return Integer.parseInt(scanned);
    }

    public static int inputPoint() {
        String scanned;

        System.out.println("## 결제를 진행합니다.");
        do {
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            scanned = SCANNER.nextLine();
        }
        while (!Validator.isNaturalNumber(scanned));
        return Integer.parseInt(scanned);
    }

    public static boolean inputCardOrNot() {
        String scanned;

        do {
            System.out.println("## 신용카드는 1번, 현금은 2번");
            scanned = SCANNER.nextLine();
        }
        while (!scanned.equals("1") && !scanned.equals("2"));
        return scanned.equals("1");
    }

}
