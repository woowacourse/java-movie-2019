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
		tryReserveMovieIfError(playSchedule, personnel); // 예외 발생시 재시작합니다.
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
	
	public static void tryReserveMovieIfError(PlaySchedule playSchedule, int personnel) {
    	if (checkReservationError(playSchedule, personnel)) {
    		reserveMovie();
    	}	
    }
	
	private static boolean checkReservationError(PlaySchedule playSchedule, int personnel) {
		if (!checkOneHourRange(playSchedule)) {
			return false;
		}
		if (!checkExcessPersonnel(personnel)) {
			return false;
		}
		return true;
		
	}
	
	private static int choicePersonnel(PlaySchedule playSchedule) {
		int personnel = InputView.inputPersonnel();
		return personnel;
	}
	
	private static boolean checkOneHourRange(PlaySchedule playSchedule) {
		boolean check = true;
		for (ReservationHistory reservationHistory: reservationHistories) {
			check = (!reservationHistory.checkOneHourRange(playSchedule)) ? false : check;
		}
		return check;
	}
	
	private static boolean checkExcessPersonnel(int personnel) {
		boolean check = true;
		for (ReservationHistory reservationHistory: reservationHistories) {
			check = (!reservationHistory.checkExcessPersonnel(personnel)) ? false : check;
		}
		return check;
	}
}
