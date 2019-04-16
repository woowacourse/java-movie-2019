package view;

import domain.Movie;
import domain.MovieRepository;
import utils.InputUtil;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovie() {
        System.out.println("## 예약할 영화를 선택하세요.");
        //여기서 예외처리해서 없는 영화 확인할 것
        return MovieRepository.getWantMovie(InputUtil.getInt());
    }
    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int InputTimeScheduleIndex() {
        System.out.println("# 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번");
        return InputUtil.getInt();
    }

    public static int inputCustomerBuyCount() {
        System.out.println("# 예약할 인원을 입력");
        return InputUtil.getInt();
    }

    public static boolean checkExit() {
        System.out.println("# 예약을 종료하고 결제를 완료하려면 1번, 추가 예약하실려면 2번을 눌러주세요");
        if (InputUtil.getInt() == 1) {
            return false;
        }
        return true;
    }

    public static int inputPoint() {
        System.out.println("## 결제 진행합니다");
        System.out.println("포인트 사용금액을 입력하세요");
        return InputUtil.getInt();
    }

    public static int getCreditOrCash() {
        System.out.println("신용카드는 1번 현금은 2번");
        return InputUtil.getInt();
    }
}
