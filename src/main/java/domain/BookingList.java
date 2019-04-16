package domain;

import java.util.List;

public class BookingList {
    private final static int CARD = 1;
    private final static int CASH = 2;

    private List<Booking> bookings;

    public BookingList(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getTotalPrice(int point, int paymentOption) {
        int totalPrice = 0;
        for (Booking booking : bookings)
            totalPrice += booking.getTotalPrice();

        return getDiscountPrice(totalPrice - point, paymentOption);
    }

    private int getDiscountPrice(int totalPrice, int paymentOption) {
        if (paymentOption == CARD)
            return totalPrice * 95 / 100;
        else if (paymentOption == CASH)
            return totalPrice * 98 / 100;

        throw new IllegalArgumentException("신용카드 혹은 현금만 결제 가능합니다.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Booking booking : bookings)
            sb.append(booking);
        return sb.toString();
    }
}
