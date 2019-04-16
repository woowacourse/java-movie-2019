package domain;

import utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Booking> bookings;

    public Basket() {
        bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) throws IllegalArgumentException {
        if (bookings.size() > 0)
            canBooking(booking);
        bookings.add(booking);
    }

    private void canBooking(Booking newBooking) {
        for (Booking myBooking : bookings)
            if (DateTimeUtils.isOneHourWithinRange(myBooking.getPlaySchedule().getStartDateTime()
                    , newBooking.getPlaySchedule().getStartDateTime()))
                throw new IllegalArgumentException("기존예매 영화와의 시간차이가 1시간이내입니다. 다시 선택해주세요.");
    }

    public List<Booking> getBookingList() {
        return bookings;
    }
}
