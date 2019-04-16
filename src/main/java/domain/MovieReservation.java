package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;

public class MovieReservation {
	private static final int ADDITIONAL_RESERVATION = 1;
	private static final int PAYMENT = 2;
	private static final int CREDIT_CARD = 1;
	private static final int CASH = 2;
	private static final double CASH_DISCOUNT = 0.02;
	private static final double CREDIT_CARD_DISCOUNT = 0.05;
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
			return;
		}
		OutputView.printMovieTickets(movieTickets);
		pay();
	}
	
	private void pay() {
		point = getPoint();
		paymentFlag = getPaymentFlag();
		double discount = paymentFlag == CREDIT_CARD ? CREDIT_CARD_DISCOUNT : CASH_DISCOUNT;
		int totalPrice = getTotalPrice();
		int finalPrice = totalPrice - (int)(totalPrice * discount) - point;
		
		OutputView.printFinalPrice(finalPrice);
	}
	
	private int getTotalPrice() {
		int price = 0;
		
		for(MovieTicket movieTicket : movieTickets) {
			price += movieTicket.getPrice();
		}
		return price;
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
