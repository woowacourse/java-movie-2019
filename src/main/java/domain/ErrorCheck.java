package domain;

import java.util.List;

public class ErrorCheck {
	
	public static boolean isValidMovie(int movieId) {
		boolean result = false;
		List<Movie> movies = MovieRepository.getMovies();
		for(Movie movie : movies) {
			result |= (movie.getMovieId == movieId);
		}
		if(!result) {
			System.out.println("Error! - 유효하지 않은 영화 번호 입니다! 다시 입력해주세요.");
		}
		
	}
	
	public static void printNotValidPeopleError() {
		System.out.println("예매 가능 인원을 초과하였습니다.");
	}
	
	public static void printOneHourError() {
		System.out.println("두 영화가 한시간 이상 차이납니다.");
	}
	
	public static void printNotValidTimeError() {
		System.out.println("이미 지난 시간 영화이므로 예매할 수 없습니다.");
	}

}
