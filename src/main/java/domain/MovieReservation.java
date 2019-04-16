package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

public class MovieReservation {
    private final int id;
    private final int price;
    private final LocalDateTime time;
    private final int numReserve;

    @Override
    public String toString() {
        return "MovieReservation{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", numReserve=" + numReserve +
                '}';
    }

    public MovieReservation(int id, int price, LocalDateTime time, int numReserve) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.numReserve = numReserve;
    }

    public int getNumReserve() {
        return numReserve;
    }

    public int totalPrice() {
        return price * numReserve;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isOneHourWithinRange(LocalDateTime time) {
        return DateTimeUtils.isOneHourWithinRange(this.time, time);
    }

    public int getID() {
        return id;
    }
}
