package domain;

public class Reservation {
	private static final char NEW_LINE = '\n';

	private Movie movie;
	private PlaySchedule playSchedule;
	private int capacity;

	public Reservation(Movie movie, PlaySchedule playSchedule, int capacity) {
		super();
		this.movie = movie;
		this.playSchedule = playSchedule;
		this.capacity = capacity;
	}

	public int calculateEachMoviePrice() {
		return movie.getTotalPrice(capacity);
	}

	public void printBookingResult() {
		System.out.println("예약 내역");
		System.out.println(movie);
		System.out.println(playSchedule);
		System.out.println("예약 인원 : " + capacity);
	}

	@Override
	public String toString() {
		return "예약 내역" + NEW_LINE + movie.getMovieSummary() +
			playSchedule.getPlayScheduleSummary() + "예약 인원 : " + capacity + NEW_LINE;
	}

}
