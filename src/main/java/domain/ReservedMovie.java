package domain;

/*
 * 예약할 영화 정보를 의미하는 객체
 */
public class ReservedMovie {
	private static final char NEW_LINE = '\n';

	private static Movie movie;
	private static PlaySchedule playSchedule;
	private static int peopleNumber;

	public ReservedMovie(Movie movie, PlaySchedule playSchedule, int peopleNumber) {
		this.movie = movie;
		this.playSchedule = playSchedule;
		this.peopleNumber = peopleNumber;
	}

	@Override
	public String toString() {
		return movie.getMovieInfo() + NEW_LINE + playSchedule.getScheduleInfo() + NEW_LINE + "예약 인원: " + peopleNumber
				+ "명";
	}
}
