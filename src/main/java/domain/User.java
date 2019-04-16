package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Reservation> reservationList = new ArrayList<>();
    private int point;

    public User() {
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public List<Reservation> getReservationList() {
        return this.reservationList;
    }

    public int sumOfPrice() {
        int sumOfPrice = 0;
        for (Reservation reservation : reservationList) {
            sumOfPrice += reservation.price();
        }
        return sumOfPrice;
    }

    public int getPayment() {
        return this.sumOfPrice() - this.point;
    }

    @Override
    public String toString() {
        return "최종 결제한 금액은 " + this.getPayment() + "원 입니다.\n"
                + "예매를 완료했습니다. 즐거운 영화 관람되세요.";
    }


}
