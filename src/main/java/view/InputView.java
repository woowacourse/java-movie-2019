package view;

import domain.Movie;
import domain.PlaySchedule;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * 예약할 영화를 선택
     */
    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    /*
     * 예약할 영화의 시간을 선택
     */
    public static int inputMovieSchedule(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }

    /*
     * 예약할 영화의 시간에 입장할 인원을 선택
     */
    public static int inputMovieReservePerson() {
        System.out.println("## 예약할 인원을 입력하세요.");
        return scanner.nextInt();
    }

    /*
     * 예약을 계속 할 지, 결제를 할 지 선택
     */
    public static int inputReserveOrPurchase() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return scanner.nextInt();
    }
}
