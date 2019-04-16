package domain;

import java.time.LocalDateTime;

public class MyMovie {
	private final Movie myMovie;
	private final int peopleNum;
	private final PlaySchedule movieTime;
	
	public MyMovie(Movie movie, int peopleNum, PlaySchedule selectedMovieTime) {
		this.myMovie = movie;
		this.peopleNum = peopleNum;
		this.movieTime = selectedMovieTime;
	}
	
	public Movie getMyMovie() {
		return this.myMovie;
	}
	
	public int getPeopleNum() {
		return this.peopleNum;
	}
	
	public PlaySchedule getMovieTime() {
		return this.movieTime;
	}
}
