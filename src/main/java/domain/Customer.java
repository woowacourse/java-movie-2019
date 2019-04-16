package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Reservation> reservationList;

    public Customer() {
        reservationList = new ArrayList<>();
    }

    public void reservation(Reservation reservation) {
        reservationList.add(reservation);

    }

    public double payment(int point, int payMentType) {
        double price = 0;
        double discount_rate = PaymentTypeEnum.getValue(payMentType).getDiscountRate();

        for (Reservation reservation : reservationList) {
            price += reservation.getPrice();
        }

        price = (price - point) * discount_rate;

        return price;
    }

    public List<LocalDateTime> getBookedTime() {
        List<LocalDateTime> bookedTime = new ArrayList<>();

        for (Reservation r : reservationList) {
            bookedTime.add(r.getPlaySchedule().getStartDateTime());
        }

        return bookedTime;
    }
}
