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
}
