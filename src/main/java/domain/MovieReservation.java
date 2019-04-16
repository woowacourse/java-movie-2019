package domain;

import view.InputView;
import java.util.ArrayList;
import java.util.List;

public class MovieReservation {
    
	private static List<ReservationHistory> reservationHistories = new ArrayList<>();
	
	public static List<ReservationHistory> getreservationHistories() {
		return reservationHistories;
	}
    
    public static void reserveMovie() {
		Movie movie = choiceMovie();
		PlaySchedule playSchedule = choicePlaySchedule(movie);
		int personnel = choicePersonnel(playSchedule);
		ReservationHistory reservationHistory =new ReservationHistory(movie, playSchedule, personnel);
		
		reservationHistories.add(reservationHistory);
	}
	
	private static Movie choiceMovie() {
		int movieId = InputView.inputMovieId();
		return MovieRepository.getMovie(movieId);
	}
	
	private static PlaySchedule choicePlaySchedule(Movie movie) {
		int index = InputView.inputPlayScheduleIndex();
		return movie.getPlaySchedule(index);
	}
	
	private static int choicePersonnel(PlaySchedule playSchedule) {
		int personnel = InputView.inputPersonnel();
		return personnel;
	}
}
