package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;
    private final int ZERO = 0;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String toStringPurchaseInfo() {
    	return "시작시간: " + format(startDateTime)+"\n";
    }
    
    public boolean isSchedule() {
    	LocalDateTime now = LocalDateTime.now();
    	
    	if (now.isAfter(startDateTime)) {
    		System.out.println("상영 시작 시간이 이미 지난 영화입니다.");
    		return false;
		}
    	return true;
    }

    public boolean isCapacity(int purchaseAmount) {
    	if (purchaseAmount == ZERO) {
    		System.out.println("0명을 유효하지 않은 인원입니다..");
			return false;
		}
    	
    	if (this.capacity < purchaseAmount) {
    		System.out.println("예매 가능한 인원을 초과했습니다.");
			return false;
		}
    	return true;
    }
}
