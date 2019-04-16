package domain;

public class Purchase {
    private static final int CARD = 1;
    private static final int CASH = 2;
    private static final double CARD_RATE = 0.05;
    private static final double CASH_RATE = 0.02;

    private int totalPrice;

    public Purchase(int totalPrice) {
        this.totalPrice = totalPrice;
        System.out.println("\n결제를 진행합니다.");
    }

    public void printTotalPayment(int point, int way) {
        int totalPayment = (int) decideTotalPayment(point, way);
        System.out.format("최종 결제한 금액은 %d원 입니다.\n", totalPayment);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요");
    }

    private double decideTotalPayment(int point, int way) {
        return (totalPrice - point) * (1 - discountRate(way));
    }

    private double discountRate(int way) {
        double rate = 0;
        if (way == CARD) {
            rate = CARD_RATE;
        } else if (way == CASH) {
            rate = CASH_RATE;
        }
        return rate;
    }
}
