package domain;

public class Payment {
    private int totalPrice;

    public Payment(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void applyPoint(int point){
        if (point > totalPrice){
            totalPrice = 0;
            return;
        }
        totalPrice -= point;
    }

    public void calculatePaymentTypeDiscount(int paymentType){
        if (paymentType == 1){
            totalPrice *= 0.95;
        }
        if (paymentType == 2){
            totalPrice *= 0.98;
        }
    }

    @Override
    public String toString(){
        return "최종 결제한 금액은 " + this.totalPrice + "입니다.";
    }
}
