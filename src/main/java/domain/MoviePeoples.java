package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DateTimeUtils;

public class MoviePeoples {
	//영화보는애들.
	private Map<Movie,Integer> reservation;

	public MoviePeoples() {
		reservation = new HashMap<Movie,Integer>();
	}
	//타임리스트 비어있으면 .... 여기에 내가 보려는 영화 플레이스케쥴 넣자. 
	//안 비어있으면 for문 돌면서. 거기 시작 시간들이랑 다 한시간 차이 나는지 메소드 돌리고 참이면 넣자
	// 거짓이면 예외처리  => 다시 시간표 고르는 메소드 가자 
	
	
	//영화 스케쥴 들어갔으면. (해당 영화객체와, 그 스케쥴 리스트이 인덱스 기억하자)
	// 예약 인원 고른다.   
	// 인원이 초과되면 예외처리 (해당 스케쥴 객체의 남은 자리 값과 인원 값 비교 )
	// 예약 가능하면 
	// movie 객체와  플레이스케쥴 , 인원 
	//2번 선택시
	
	//지금 타임 테이블에서 시간 표 목록 뽑는다.
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

	//고른 영화와, 시간표 목록.  유효한 시간이니??  이게 참이면 ... 티켓표로 갯수 넘어가고 아니면 앞에 재호출
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
		//영화 객체의 idx 번째 시간 자리랑 비교 
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
		/*
		if(!res) {
			//한시간 넘어가는 영화 있는거야 그러면 예외 처리
			//예외 넘져 출력하고
		}*/
		//시간 문제는 없다. 영화 객체 계속 기억해 , 그리고 인덱스도 기억해
		
		//예약 인원 고르기... 
		//movie , playSchedule  매개변수 
		//int 숫자 입력받기. 
		//원래 영화 리스트의 숫자와  피플 객체안 영화 리스트 숫자 + 인풋값 비교
		//크기 넘어가면  예외다 !!!!  예약인원 고르기 다시 호출  
		//유효한 범위라면 , Peoples 객체에 있는 영화 리스트에 값 집어 넣자.
	
	

	//조건에 맞는 영화와 스케쥴 표 넣는다. 
	/*public void addMovie(Movie movie, PlaySchedule schedule) {
		movieList.add(movie);
		movie.addPlaySchedule(schedule);
	}*/
	
	
}
