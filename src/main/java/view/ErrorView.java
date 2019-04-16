package view;

public class ErrorView {
	
	public static void printNotValidTimeError() {
		System.out.println("이미 지난 시간 영화이므로 예매할 수 없습니다.");
	}
	
	public static void printNotValidPeopleError() {
		System.out.println("예매 가능 인원을 초과하였습니다.");
	}
	
	public static void printOneHourError() {
		System.out.println("두 영화가 한시간 이상 차이납니다.");
	}
	
	public static void printNotValidMovieError() {
		System.out.println("상영 목록에 없는 영화입니다.");
	}

}
