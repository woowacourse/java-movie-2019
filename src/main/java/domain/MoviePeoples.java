package domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DateTimeUtils;

public class MoviePeoples {

	private Map<Movie,Integer> reservation;

	public MoviePeoples(List<Movie> movies) {
		reservation = new HashMap<Movie,Integer>();
		for (Movie movie : movies) {
			//movie.initCapacity();
			reservation.put(movie, 0);
		}
	}
	
	public Set<LocalDateTime> getTimeList() {
		Set<LocalDateTime> result = new HashSet<>();
		for (Movie movie : reservation.keySet()) {
			addAllTime(result,movie.getPlaySchedule());	// 한영화의 스케쥴 리스트
		}
		
		return result;
	}
	
	private void addAllTime(Set<LocalDateTime> result, List<PlaySchedule> playSchedule) {
		for (PlaySchedule oneSchedule : playSchedule) {
			result.add(oneSchedule.getStartTime());
		}
	}

	public boolean resultget(Movie movie,int idx) {
		boolean res = true;
		PlaySchedule ps = movie.getPlaySchedule().get(idx-1);		//i번을 입력했을때 값

		for (LocalDateTime time : getTimeList()) {
			res = res && 
					DateTimeUtils
					.isOneHourWithinRange(ps.getStartTime(), time);
		}
		
		return res;
	}	
	
	public boolean isAvailable(Movie movie,int idx,int plus) {
		
		Movie ourMovie = getSameMovie(movie);
		return !ourMovie.getPlaySchedule().get(idx)
		.isFull(movie.getPlaySchedule().get(idx), plus);
	}
	private Movie getSameMovie(Movie movie) {
		Movie res = null;
		for (Movie mov : reservation.keySet()) {
			if (mov.isSame(movie)) {
				res = mov;
			}
		}
		return res;
	}
		
}
