package view;

import java.util.List;

import domain.Movie;
import domain.SelectedMovie;

public class OutputView {
	public static boolean printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		return true;
	}

	public static boolean printSelectedMovies(List<SelectedMovie> selectedMovies) {
		for (SelectedMovie selectedMovie : selectedMovies) {
			System.out.println(selectedMovie);
		}
		return true;
	}
	public static boolean printTotalPrice(int totalPrice) {
		System.out.println("최종 결제한 금액은 "+totalPrice+" 원 입니다. \n예매를 완료했습니다. 즐거운 영화관람되세요.");
		return true;
	}
}
