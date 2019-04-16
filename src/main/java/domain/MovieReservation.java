package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;

public class MovieReservation {
	private static final int ADDITIONAL_RESERVATION = 1;
	private static final int PAYMENT = 2;
	private static final int CREDIT_CARD = 1;
	private static final int CASH = 2;
	private static final String INVALID_ADDITIONAL_RESERVATION_FLAG_MESSAGE = ADDITIONAL_RESERVATION + " 혹은 " + PAYMENT + "를 입력해주세요.";
	private static final String INVALID_PAYMENT_FLAG_MESSAGE = CREDIT_CARD + " 혹은 " + CASH + "를 입력해주세요.";
	private static final String INVALID_POINT_MESSAGE = CREDIT_CARD + "0 이상의 정수를 입력해주세요.";
	
	private List<MovieTicket> movieTickets;
	private int paymentFlag;
	private int point;
	
	public MovieReservation() {
		movieTickets = new ArrayList<MovieTicket>();
	}
	
	public void reserve() {
		MovieTicket movieTicket = new MovieTicket();
		movieTickets.add(movieTicket);
		
		if(getAdditionalReservationFlag() == 1) {
			reserve();
		}
	}
	
	private void pay() {
		
	}
	
	private int getAdditionalReservationFlag() {
		int additionalReservationFlag = InputView.inputAdditionalReservationFlag();
		if (!(additionalReservationFlag==ADDITIONAL_RESERVATION || 
				additionalReservationFlag==PAYMENT)) {
			System.out.println(INVALID_ADDITIONAL_RESERVATION_FLAG_MESSAGE);
			return getAdditionalReservationFlag();
		}

		return additionalReservationFlag;
		
	}
	
	private int getPoint() {
		int point = InputView.inputPaymentFlag();
		if (point < 0) {
			System.out.println(INVALID_POINT_MESSAGE);
			return getPoint();
		}
		
		return point;
	}
	
	private int getPaymentFlag() {
		int paymentFlag = InputView.inputPaymentFlag();
		if (!(paymentFlag==CREDIT_CARD || 
				paymentFlag==CASH)) {
			System.out.println(INVALID_PAYMENT_FLAG_MESSAGE);
			return getPaymentFlag();
		}
		
		return paymentFlag;
	}
	
	
}
