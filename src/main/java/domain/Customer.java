package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	public int movieId;
	public int movieTime;
	public int ticketNum;
	public int nextStep;
	public int point;
	public Movie curMovie;
	public PlaySchedule curPlaySchedule;
	public List<Integer> users = new ArrayList<Integer>();
	public List<PlaySchedule> playSchedules;
	public List<Movie> userMovies = new ArrayList<Movie>();
	public List<PlaySchedule> userSchedules = new ArrayList<PlaySchedule>();

	public List<PlaySchedule> getPlaySchedules() {
		return playSchedules;
	}

	public void setPlaySchedules(List<PlaySchedule> playSchedules) {
		this.playSchedules = playSchedules;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getMovieTime() {
		return movieTime;
	}

	public int getNextStep() {
		return nextStep;
	}

	public List<Movie> getUserMovies() {
		return userMovies;
	}

	public List<PlaySchedule> getUserSchedules() {
		return userSchedules;
	}

	public void setUserSchedules(List<PlaySchedule> userSchedules) {
		this.userSchedules = userSchedules;
	}

	public void setUserMovies(List<Movie> userMovies) {
		this.userMovies = userMovies;
	}

	public void setNextStep(int nextStep) {
		this.nextStep = nextStep;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}
	
	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public void setUsers(List<Integer> users) {
		this.users = users;
	}

	public void addMovie(int movieTime) {
		for(Movie movie : MovieRepository.getMovies()) {
			if(movie.getId() == movieId) {
				userMovies.add(movie);
				curMovie = movie;
			}
		}
		users.add(ticketNum);
		userSchedules.add(playSchedules.get(movieTime - 1));
		curPlaySchedule = playSchedules.get(movieTime - 1);
	}

	public boolean checkGroupSchedule() {
		boolean isValid = false;
		PlaySchedule userPlaySchedule = playSchedules.get(movieTime - 1);
		for(PlaySchedule groupSchedule : userSchedules) {
			isValid = utils.DateTimeUtils.isOneHourWithinRange(groupSchedule.getStarDateTime(), userPlaySchedule.getStarDateTime());
			if(isValid == true) break;
		}
		return isValid;
	}
	
	public void buyTickets() {
		for(Movie movie : MovieRepository.getMovies()) {
			for(PlaySchedule playSchedule : movie.getPlaySchedules()) {
				if(movie.equals(curMovie) && playSchedule.equals(curPlaySchedule)){
					playSchedule.buyTickets(ticketNum);
				}
			}
		}
	}

	public int calculateResult() {
		int total = 0;
		
		for(Movie movie : userMovies) {
			total = total + movie.getPrice() * ticketNum;
		}
		total = total - point;
		return total;
	}
	
	
}
