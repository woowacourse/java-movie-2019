package domain;

public class PaymentOrReservation {
    private final int paymentOrReservation;


    public PaymentOrReservation(int paymentOrReservation){
        if(!(paymentOrReservation == 1 || paymentOrReservation == 2)){
            throw new IllegalArgumentException("결제는 1번, 추가예약은 2번입니다.");
        }
        this.paymentOrReservation = paymentOrReservation;
    }

    public int getPaymentOrReservation() {
        return paymentOrReservation;
    }

}
