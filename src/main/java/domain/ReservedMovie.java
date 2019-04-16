package domain;
/*
 * 예약할 영화 정보를 의미하는 객체
 */
public class ReservedMovie {
	private static Movie movie;
	private static PlaySchedule playSchedule;
	private static int peopleNumber;
	
	public ReservedMovie(Movie movie, PlaySchedule playSchedule, int peopleNumber) {
		this.movie = movie;
		this.playSchedule = playSchedule;
		this.peopleNumber = peopleNumber;
	}
}
