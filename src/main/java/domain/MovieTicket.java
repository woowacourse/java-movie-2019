package domain;

import view.InputView;

public class MovieTicket {
	private static final String UNKNOWN_MOVIE_ID_MESSAGE = "상영 목록에 없는 영화입니다.";
	private static final String UNKNOWN_SCHEDULE_MESSAGE = "상영 목록에 없는 시간표입니다.";
	
	private Movie movie;
	private int numOfAudience;
	
	public MovieTicket() {
		int movieId = getMovieId();
		int schedule = getSchedule(movieId);
		int numOfAudience = getNumOfAudience();
	}
	
	private int getMovieId() {
		int movieId = InputView.inputMovieId();
		if(!MovieRepository.containsMovieId(movieId)) {
			System.out.println(UNKNOWN_MOVIE_ID_MESSAGE);
			return getMovieId();
		}
		
		return movieId;
	}
	
	private int getSchedule(int movieId) {
		int schedule = InputView.inputSchedule();
		if(!MovieRepository.containsSchedule(movieId, schedule)) {
			System.out.println(UNKNOWN_MOVIE_ID_MESSAGE);
			return getSchedule(movieId);
		}
		
		return schedule;
		
	}
	
	private int getNumOfAudience() {
		int numOfAudience = InputView.inputNumOfAudience();
		return 0;
		
	}
}
