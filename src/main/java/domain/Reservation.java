package domain;

import java.time.LocalDateTime;
import static utils.DateTimeUtils.format;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
	private static final char NEW_LINE = '\n';
	
	private final int id;
	private final String name;
	private final int price;
	private final LocalDateTime time;
	private final int num;
	
	public Reservation(int id, String name, int price, LocalDateTime time, int num) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.time = time;
		this.num = num;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        return id + " - " + name + ", " + price + "원" + NEW_LINE 
        		 + "시작시간: " + format(time) + NEW_LINE 
        		 + "예약 인원: " + num + "명";
	}
	
}
