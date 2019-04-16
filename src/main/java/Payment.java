import javax.swing.plaf.synth.SynthSpinnerUI;

import domain.Movie;
import view.InputView;

public class Payment {

	private Movie movie;
	private int scheduleId;
	private int reserveMenCount;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Payment(Movie movie) {

		this.movie = movie;

	}

	public Movie getMovie() {
		return movie;
	}

	public int getReserveMenCount() {
		return reserveMenCount;
	}

	public void setReserveMenCount(int reserveMenCount) {
		this.reserveMenCount = reserveMenCount;
	}

	public void printPayment() {
		System.out.println("예약 내역");
		System.out.println(movie.getId() + "-" + movie.getName() + "," + movie.getPrice());
		System.out.print(movie.getPlaySchedules().get(scheduleId-1));
		System.out.println("예약인원 : " + reserveMenCount);
	}

}
