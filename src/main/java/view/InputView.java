package view;

import java.util.List;
import java.util.Scanner;

import domain.MovieRepository;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId() {
		try {
			System.out.println("## 예약할 영화를 선택하세요.");
			return isValidId(scanner.nextLine());
		} catch (Exception e) {
			return inputMovieId();
		}
	}

	private static int isValidId(String inputId) {
		return isValidScope(Integer.valueOf(inputId));
	}

	private static int isValidScope(int inputId) {
		List<Integer> moviesId = MovieRepository.getMoviesId();
		if (moviesId.contains(inputId)) {
			return inputId;
		}
		throw new IllegalArgumentException();
	}
}
