package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String WRONG_INPUT = "잘못된 입력입니다.";

	public static int inputMovieId() {
		System.out.println("## 예약할 영화를 선택하세요.");
		try {
			return Integer.parseInt(scanner.next());
		} catch (Exception e) {
			System.out.println(WRONG_INPUT);
			return inputMovieId();
		}
	}
}
