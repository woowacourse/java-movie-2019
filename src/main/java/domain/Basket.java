package domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Booking> bookings;

    public Basket() {
        bookings = new ArrayList<>();
    }


    public List<Booking> getBookingList() {
        return bookings;
    }
}
