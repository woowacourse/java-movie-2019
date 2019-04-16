package domain;

public class MyMovie {
	private static final String NEW_LINE = "\n";
	private final Movie myMovie;
	private final int peopleNum;
	private final PlaySchedule movieTime;
	
	public MyMovie(Movie movie, PlaySchedule selectedMovieTime, int peopleNum) {
		this.myMovie = movie;
		this.movieTime = selectedMovieTime;
		this.peopleNum = peopleNum;
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
	
	public String toString() {
		String result = "";
		result += "예약 내역" + NEW_LINE;
		result += myMovie.getMovieInfo() + NEW_LINE;
		result += "시작시간: " + this.movieTime.getStartDateTime() + NEW_LINE;
		result += "예약 인원: " + this.peopleNum + "명";
		return result;
	}
}
