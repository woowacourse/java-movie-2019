package domain;

import utils.NaturalNumber;

public class Payment {
	private int point;
	private int payType;
	private ReservationRepository reservationRepository;

	public Payment(ReservationRepository reservationRepository) {
		this.point = 0;
		this.payType = 1;
		this.reservationRepository = reservationRepository;
	}

	public void payPoint(NaturalNumber point) {
		if (point.getNumber() > reservationRepository.getTotalPrice()) {
			throw new IllegalArgumentException("포인트가 결제 금액보다 큽니다.");
		}
		this.point = point.getNumber();
	}

	public int pay(NaturalNumber payType) {
		this.payType = payType.getNumber();
		paying();
		return reservationRepository.getTotalPrice();
	}

	public void paying() {
		reservationRepository.completeReservations();
	}
}
