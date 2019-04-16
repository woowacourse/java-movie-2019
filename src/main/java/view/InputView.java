package view;

import domain.Money;
import domain.MovieRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final int PAYMENT = 1;
    private static final int ADD_RESERVATION = 2;

    public static int inputMovieId() throws IOException {
        int movieId = valid("## 예약할 영화를 선택하세요.");
        if(MovieRepository.getMovie(movieId) == null){
            System.out.println("## 영화 번호를 정확히 입력해주세요.");
            return inputMovieId();
        }
        return movieId;
    }

    public static int inputScheduleNumber(int scheduleSize) throws IOException{
        int scheduleNumber = valid("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        if(scheduleNumber > scheduleSize){
            System.out.println("## 없는 시간표 입니다. 다른 번호를 선택해주세요.");
            return inputScheduleNumber(scheduleSize);
        }
        return scheduleNumber;
    }

    public static int inputReservationPersonnel() throws IOException{
        return valid("## 예약 할 인원을 입력하세요.");
    }

    public static boolean goPaymentOrAddReservation() throws IOException{
        int number = valid("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        if(number == PAYMENT){
            return false;
        }
        if(number == ADD_RESERVATION){
            return true;
        }
        System.out.println("잘못된 숫자를 입력하셨습니다.");
        return goPaymentOrAddReservation();
    }

    public static long inputPoint(Money money) throws IOException{
        int point = valid("## 결제를 진행합니다.\n"+"## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        if(!money.isValidMoney(point)){
            System.out.println("## 포인트가 결제 금액보다 많습니다. 다시 입력해주세요.");
            return inputPoint(money);
        }
        return point;
    }

    public static int inputCashOrCard() throws IOException{
        int inputNumber = valid("## 신용카드는 1번, 현금은 2번");
        return inputNumber;
    }

    private static int valid(String message) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        try{
            int temp = Integer.parseInt(bf.readLine());
            return temp;
        }catch (IllegalArgumentException e){
            System.out.println("## 올바른 형식으로 입력해 주세요. (숫자)");
            return valid(message);
        }

    }
}
