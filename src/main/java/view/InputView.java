package view;

import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final double CARD_DISCOUNT_RATE = 0.95;
    private static final double CASH_DISCOUNT_RATE = 0.98;

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            int movieId = scanner.nextInt();
            if (MovieRepository.getMovies(movieId).isEmpty()) {
                throw new Exception("상영 목록에 없는 영화입니다.");
            }
            return movieId;
        } catch (Exception e) {
            System.out.println("## 상영 목록에 없는 영화입니다.");
            return inputMovieId();
        }
    }

    public static int inputMovieTime() {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        return scanner.nextInt();
    }

    public static int inputMovieViewer() {
        System.out.println("## 예약할 인원을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPayOrAdditionalReservation() {
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
            int input = scanner.nextInt();
            if (input != 1 && input != 2) {
                throw new Exception("잘못된 번호");
            }
            return input;
        } catch (Exception e) {
            System.out.println("## 잘못누르셨습니다.");
            return inputPayOrAdditionalReservation();
        }
    }

    public static int inputPoint() {
        try {
            System.out.println("## 결제를 진행합니다.");
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            int point = scanner.nextInt();
            if (point < 0) {
                throw new Exception("음수 입력");
            }
            return point;
        } catch (Exception e) {
            System.out.println("## 잘못 입력하셨습니다.");
            return inputPoint();
        }
    }

    public static double inputCardOrCash() {
        try {
            System.out.println("## 신용카드는 1번, 현금은 2번");
            int input = scanner.nextInt();
            if (input != 1 && input != 2) {
                throw new Exception("잘못된 번호");
            }
            if (input == 1) {
                return CARD_DISCOUNT_RATE;
            }
            return CASH_DISCOUNT_RATE;
        } catch (Exception e) {
            System.out.println("## 잘못누르셨습니다.");
            return inputCardOrCash();
        }
    }
}
