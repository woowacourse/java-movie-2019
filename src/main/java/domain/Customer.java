package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    int point;
    private List<Ticket> reserveList = new ArrayList<>();

    public Customer(int point) {
        this.point = point;
    }

    public void reserve(Ticket ticket) {
        reserveList.add(ticket);
    }

    public List<Ticket> getReserveList() {
        return reserveList;
    }

    public int getPoint() {
        return point;
    }
}