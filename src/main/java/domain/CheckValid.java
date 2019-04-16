package domain;

import java.util.List;

import view.OutputView;

public class CheckValid {
	
	private static Customer customer;
	
	public CheckValid(Customer customer, MovieRepository repository) {
		this.customer = customer;
	}

	public boolean checkMovieId(int movieId) {
		boolean isValid = false;
		List<Movie> movies = MovieRepository.getMovies();
		for(Movie movie : movies) {
			if(movie.getId() == movieId) isValid = true;
		}
		if(isValid == false) OutputView.printErr(0);
		return isValid;
	}
	
	public static boolean checkTimeValid(int time) {
		boolean isValid = false;
		int scheduleSize = customer.getPlaySchedules().size();
		if(time > scheduleSize || time < 0) {
			OutputView.printErr(1);
			isValid = false;
		}
		else if(time < scheduleSize && time > 0) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean checkGroupSizeValid(int groupSize) {
		boolean isValid = false;
		
		List<PlaySchedule> playSchedules = customer.getPlaySchedules();
		int movieTime = customer.getMovieTime();
		int capacity = playSchedules.get(movieTime - 1).getCapacity();
		if(groupSize < capacity) isValid = true;
		return isValid;
	}

	public static boolean checkNextStepValid(int nextStep) {
		boolean isValid = false;
		
		if(nextStep == 1 || nextStep == 2) {
			isValid = true;
		}
		
		return isValid;
	}

	public static boolean checkPointValid(int point) {
		boolean isValid = false;
		
		if(point > 0) {
			isValid = true;
		}
		return isValid;
	}
}
