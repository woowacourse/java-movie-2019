package view;

import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        int movieId = 0;
        System.out.println("## 예약할 영화를 선택하세요.");
        movieId = scanner.nextInt();
        if(MovieRepository.getMovie(movieId) == null){
            System.out.println("## 영화 번호를 정확히 입력해주세요.");
            inputMovieId();
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

    public static int goPaymentOrAddReservation(){
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        return scanner.nextInt();
    }
}
