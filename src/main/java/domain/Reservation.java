package domain;

public class Reservation {
	private static final String RESERVATION_RESULT = "예약 내역\n";
	private static final String RESERVATION_TIME = "시작 시간:";
	private static final String RESERVATION_PERSON = "예약 인원:";
	
	private final Movie movie;
	private final int timeIndex;
	private final int people;
	
	public Reservation(int movieId, int timeIndex, int people) {
		this.movie = MovieRepository.getMovieById(movieId);
		this.timeIndex = timeIndex;
		this.people = people;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RESERVATION_RESULT);
		sb.append(movie.getMovieInfoString() + "\n");
		sb.append(RESERVATION_TIME);
		sb.append(movie.getMovieTime(timeIndex) + "\n");
		sb.append(RESERVATION_PERSON);
		sb.append(people + "명");
		return sb.toString();
	}
}
