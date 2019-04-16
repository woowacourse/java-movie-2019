package domain;

import view.InputView;

public class Billing {
    private static final float CREDIT = (float) 0.95;
    private static final float CASH = (float) 0.98;

    public static void billing(ReserveMovie reserveMovie) {
        System.out.println("## 결제를 진행합니다.");
        int point = InputView.inputPoint();
        int payment = payMovieTicket(InputView.inputBillingType(), reserveMovie, point);
        printPayment(payment);
    }

    public static void printPayment(Integer payment) {
        System.out.printf("최종 결제한 금액은 %d원 입니다.\n", payment);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관란되세요.");
    }

    public static int payMovieTicket(Integer billingType,
                                     ReserveMovie reserveMovie,
                                     Integer point) {
        if (billingType == 1) {
            return payCredit(reserveMovie, point);
        }
        return payCash(reserveMovie, point);
    }

    public static int payCredit(ReserveMovie reserveMovie, Integer point) {
        int totalPayment = reserveMovie.getTotalPrice() - point;
        return (int) (totalPayment * CREDIT);
    }

    public static int payCash(ReserveMovie reserveMovie, Integer point) {
        int totalPayment = reserveMovie.getTotalPrice() - point;
        return (int) (totalPayment * CASH);
    }
}
