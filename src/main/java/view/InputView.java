package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId() {
		try {
			System.out.println("## 예약할 영화를 선택하세요.");
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			return inputMovieId();
		}
	}
	
	public static int inputMovieTime() {
		try {
			System.out.println("## 예약할 시간표를 선택하세요.");
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			return inputMovieTime();
		}
	}	
}
