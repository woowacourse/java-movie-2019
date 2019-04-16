package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int inputMovieId() throws IOException {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException e) {
            return inputMovieId();
        }
    }

    public static int inputMovieTime() throws IOException {
        try {
            System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException e) {
            return inputMovieTime();
        }
    }

    public static int inputCountOfUser() throws IOException {
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException e) {
            return inputCountOfUser();
        }
    }

    public static boolean wantPay() throws IOException {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            int wantPay = Integer.parseInt(bufferedReader.readLine());

            if (wantPay == 1) {
                return true;
            }
            if (wantPay == 2) {
                return false;
            }
        }catch (IllegalArgumentException e){
            return wantPay();
        }
        return false;
    }

    public static int inputPoint() throws IOException {
        try {
            System.out.println("##결제를 진행합니다.");
            System.out.println("##포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException e) {
            return inputPoint();
        }

    }

    public static int cashOrCredit() throws IOException {
        try {
            System.out.println("##신용카드는 1번, 현금은 2번");
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException e) {
            return cashOrCredit();
        }
    }
}
