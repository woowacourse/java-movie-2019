package view;

import utils.ValidatorUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        int movieId;

        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            movieId = scanner.nextInt();
        } while (!ValidatorUtils.isNaturalMovieId(movieId));

        return movieId;
    }

    public static int inputScheduleNumber(int movieId) {
        int scheduleNumber;

        do {
            System.out.println("## 예약할 시간표를 선택하세요.");
            scheduleNumber = scanner.nextInt();
        } while (!ValidatorUtils.isNaturalScheduleNumber(movieId, scheduleNumber));

        return scheduleNumber;
    }

    public static int inputReservationCount(int movieId, int scheduleNumber) {
        int reservationCount;

        do {
            System.out.println("## 예약할 인원을 입력하세요.");
            reservationCount = scanner.nextInt();
        } while (!ValidatorUtils.isNaturalReservationCount(movieId, scheduleNumber, reservationCount));

        return reservationCount;
    }

    public static int inputQuitOrAdditionalReservation() {
        int answer;

        do {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            answer = scanner.nextInt();
        } while (!ValidatorUtils.isNaturalResponseForQuit(answer));

        return answer;
    }
}
