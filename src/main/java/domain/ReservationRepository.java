package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
	private List<Reservation> reservations;

	public ReservationRepository() {
		this.reservations = new ArrayList<>();
	}

	public void addReservation(Reservation reservation) {
		if (!checkOneHourWithinRange(reservation)) {
			throw new IllegalArgumentException("예약목록에 있는 관람객과 1시간 이상 차이 납니다.");
		}
		this.reservations.add(reservation);
	}

	private boolean checkOneHourWithinRange(Reservation targetReservation) {
		for (Reservation reservation : reservations) {
			if(!checkOneHourWithIn(targetReservation, reservation)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkOneHourWithIn(Reservation targetReservation, Reservation reservation) {
		return reservation.getPlaySchedule().isOneHourWithinRange(targetReservation.getPlaySchedule());
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (Reservation reservation : reservations) {
			totalPrice += reservation.calTotalPrice();
		}
		return totalPrice;
	}
}
