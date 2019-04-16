package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
    
    public boolean isSchedule() {
    	//SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
    	LocalDateTime now = LocalDateTime.now();
    	
    	if (now.isAfter(startDateTime)) {
    		System.out.println("상영 시작 시간이 이미 지난 영화입니다.");
    		return false;
		}
    	return true;
    }

    public boolean isCapacity(int purchaseAmount) {
    	if (this.capacity < purchaseAmount) {
    		System.out.println("예매 가능한 인원 초과한 영화입니다.");
			return false;
		}
    	return true;
    }
}
