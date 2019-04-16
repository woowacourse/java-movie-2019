package domain;

import java.util.ArrayList;
import java.util.List;

import static utils.DateTimeUtils.createDateTime;

public class MovieRepository {
	private static List<Movie> movies = new ArrayList<>();

	static {
		Movie movie1 = new Movie(1, "생일", 8_000);
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 12:00"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 14:40"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 17:00"), 6));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 19:40"), 3));
		movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 22:00"), 3));
		movies.add(movie1);

		Movie movie2 = new Movie(5, "돈", 10_000);
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 08:00"), 3));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 10:30"), 5));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 5));
		movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:30"), 5));
		movies.add(movie2);

		Movie movie3 = new Movie(7, "파이브피트", 9_000);
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:40"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 18:00"), 4));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 20:40"), 3));
		movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 23:15"), 3));
		movies.add(movie3);

		Movie movie4 = new Movie(8, "덤보", 9_000);
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 11:30"), 2));
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 16:00"), 3));
		movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 21:30"), 2));
		movies.add(movie4);
	}

	public static List<Movie> getMovies() {
		return movies;
	}
	
	public static String findMovieInfomation(int id) {
		return movies.get(findMovieIndex(id, 0)).toString();
	}

	public static Boolean hasMovie(int id) {
		if (findMovieIndex(id, 0) == movies.size()) {
			return false;
		}
		return true;
	}
	
	public static Boolean hasSchedule(int movieId, int scheduleNumber) {
		int movieIndex = findMovieIndex(movieId, 0);
		Movie movie = movies.get(movieIndex);
		return movie.hasSchedule(scheduleNumber);
	}
	
	public static Boolean isEndSchedule(int movieId, int scheduleNumber) {
		int movieIndex = findMovieIndex(movieId, 0);
		Movie movie = movies.get(movieIndex);
		return movie.isEnd(scheduleNumber);
	}
	
	public static Boolean hasEnoughCapacity(int movieId, int scheduleNumber, int ticketCount) {
		int movieIndex = findMovieIndex(movieId, 0);
		Movie movie = movies.get(movieIndex);
		return movie.hasEnoughCapacity(scheduleNumber, ticketCount);
	}
	
	/**
	 * 찾으려는 아이디의 영화가 저장된 인덱스를 반환하는 메소드
	 * @param id 찾으려는 영화의 아이디
	 * @param index 탐색 시작 인덱스
	 * @return 해당 아이디를 가진 영화가 있으면 그 인덱스를 반환 없으면 마지막 인덱스 + 1 값(총 영화의 개수)을 반환
	 */
	private static int findMovieIndex(int id, int index) {
		if (index >= movies.size()) {
			return index;
		}
		if (movies.get(index).isId(id)) {
			return index;
		}
		return findMovieIndex(id, index + 1);
	}
}
