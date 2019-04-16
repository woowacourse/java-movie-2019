package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String MOVIE_ID_INPUT_MESSAGE = "## 예약할 영화를 선택하세요.";

	public static int inputMovieId() {
		System.out.println(MOVIE_ID_INPUT_MESSAGE);
		try {
			return SCANNER.nextInt();
		} catch (IllegalArgumentException e) {
			return inputMovieId();
		}
	}
}
