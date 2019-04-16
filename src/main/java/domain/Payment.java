package domain;

import java.util.List;

public class Payment {
    private List<Reservation> reservationList;
    private int paymentMethod;
    private int point;

    public Payment(List<Reservation> reservationList, int paymentMethod, int point) {
        this.reservationList = reservationList;
        this.paymentMethod = paymentMethod;
        this.point = point;
    }

    public int calcTotalAmount() {
        int totalAmount = 0;
        for (Reservation reservation : reservationList) {
            totalAmount += reservation.calcMoviePrice();
        }
        return totalAmount;
    }

    public int calcDiscountedTotalAmount(int totalAmount) {
        Double discount = (paymentMethod == 1) ? 0.95 : 0.98;
        int totalAmountExceptPoint = totalAmount - point;
        return (totalAmountExceptPoint <= 0) ? 0 : (int) (totalAmountExceptPoint * discount);
    }
}
