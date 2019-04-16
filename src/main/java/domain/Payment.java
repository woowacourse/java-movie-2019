package domain;

public class Payment {
	private static final int CARD = 1;
//	private static final int CACHE = 2;
	
	private int price;
	private int point;
	private int paymentMethod;

	public Payment(int price, int point) {
		this.price = price;
		this.point = point;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	// TODO enum 사용하기
	public int calculateFinalPrice() {
		if (paymentMethod == CARD) {
			return (int)Math.round((double)(price - point) * 0.95);
		}
		return (int)Math.round((double)(price - point) * 0.98);
	}

	public void printFinalPrice() {
		System.out.println("최종 결제한 금액은 " + calculateFinalPrice() + "원 입니다.");
	}
}
