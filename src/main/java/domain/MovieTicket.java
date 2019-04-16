package domain;

import view.InputView;

public class MovieTicket {
	private static final String UNKNOWN_MOVIE_ID_MESSAGE = "상영 목록에 없는 영화입니다.";
	
	private Movie movie;
	private int numOfAudience;
	
	public MovieTicket() {
		int movieId = getMovieId();
		
	}
	
	private int getMovieId() {
		int movieId = InputView.inputMovieId();
		if(!MovieRepository.containsMovieId(movieId)) {
			System.out.println(UNKNOWN_MOVIE_ID_MESSAGE);
			return getMovieId();
		}
		
		return movieId;
	}
	
}
