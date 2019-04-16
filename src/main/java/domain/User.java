/*
 *  @(#)User.java       1.00    2019/04/16
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

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

    /* 예약 list에 추가하는 매소드 */
    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public List<Reservation> getReservationList() {
        return this.reservationList;
    }

    /* 총 가격 계산하는 메소드 */
    public int sumOfPrice() {
        int sumOfPrice = 0;
        for (Reservation reservation : reservationList) {
            sumOfPrice += reservation.price();
        }
        return sumOfPrice;
    }

    /* 총 가격에서 포인트 뺀 실제 결제할 금액 */
    public int getPayment() {
        return this.sumOfPrice() - this.point;
    }

    @Override
    public String toString() {
        return "최종 결제한 금액은 " + this.getPayment() + "원 입니다.\n"
                + "예매를 완료했습니다. 즐거운 영화 관람되세요.";
    }

}
