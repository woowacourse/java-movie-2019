package domain;

import java.time.LocalDateTime;
import static utils.DateTimeUtils.format;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
	private static final char NEW_LINE = '\n';
	
	private final Movie movie;
	private final LocalDateTime time;
	private final int num;
	
	public Reservation(Movie movie, LocalDateTime time, int num) {
		this.movie = movie;
		this.time = time;
		this.num = num;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        return movie.getMovieInfo()
        		 + "시작시간: " + format(time) + NEW_LINE 
        		 + "예약 인원: " + num + "명";
	}
	
}
