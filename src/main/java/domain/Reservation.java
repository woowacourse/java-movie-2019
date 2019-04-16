package domain;

public class Reservation {
	private Movie movie;
	private PlaySchedule playSchedule;
	private int capacity;

	public Reservation(Movie movie, PlaySchedule playSchedule, int capacity) {
		super();
		this.movie = movie;
		this.playSchedule = playSchedule;
		this.capacity = capacity;
	}

	public void printBookingResult() {
		System.out.println("예약 내역");
		System.out.println(movie);
		System.out.println(playSchedule);
		System.out.println("예약 인원 : " + capacity);
	}

}
