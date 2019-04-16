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

    public int caclTotalAmount() {
        int totalAmount = 0;
        for (Reservation reservation : reservationList) {
            totalAmount += reservation.calcMoviePrice();
        }
        return totalAmount;
    }

    public int calcDiscountedTotalAmoumt(int totalAmount) {
        Double discount = (paymentMethod == 1) ? 0.95 : 0.98;
        return (int) ((totalAmount - point) * discount);
    }
}
