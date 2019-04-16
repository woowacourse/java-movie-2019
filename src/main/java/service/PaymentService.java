package service;

public class PaymentService {

    /**
     *
     * @param price 결제 총액
     * @param point 사용할 포인트
     * @param p 결제 유형
     * @return 포인트 차감과 할인이 적용된 최종 결제 금액
     */
    public int handlePayment(int price, int point, PaymentType p) {
        if (point > price) {
            throw new IllegalArgumentException("Point can't be greater than price");
        }
        return p.getDiscountedPrice(price - point);
    }
}
