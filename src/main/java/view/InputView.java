package view;

import domain.MovieRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int PAYMENT = 1;

    public static int inputMovieId() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int movieId ;
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            movieId = Integer.parseInt(bf.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("## 올바른 형식으로 입력해 주세요. (숫자)");
            return inputMovieId();
        }
        if(MovieRepository.getMovie(movieId) == null){
            System.out.println("## 영화 번호를 정확히 입력해주세요.");
            return inputMovieId();
        }
        return movieId;
    }

    public static int inputScheduleNumber() {
        System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }

    public static int inputReservationPersonnel(){
        System.out.println("## 예약 할 인원을 입력하세요.");
        return scanner.nextInt();
    }

    public static boolean goPaymentOrAddReservation(){
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        int number = scanner.nextInt();
        if(number == PAYMENT){
            return false;
        }
        return true;
    }
}
