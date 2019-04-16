package domain;

public class Vaild {
	public boolean PaymentVaild(int MoviePay,int PointPay) {
		boolean result = false;
		if (PointPay < 0) {
			System.out.println("포인트는 0보다 큰 수만 입력가능합니다. 포인트가 없으시면 0을 입력해주세요.");
			result = true;
		}
		
		if (PointPay > MoviePay) {
			System.out.println("입력하신 포인트가 영화 가격보다 높습니다. 사용할 포인트를 다시 입력해주세요.");
			result = true;
		}
		return result;
	}
}
