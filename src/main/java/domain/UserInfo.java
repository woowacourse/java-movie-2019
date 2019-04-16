package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class UserInfo {
    private final static int DEFAULT_POINT = 10_000;

    private List<MovieBookingInfo> movieList = new ArrayList<>();
    private int point = DEFAULT_POINT;

    public int getPoint() {
        return point;
    }

    public void addMove(MovieBookingInfo movieBookingInfo) {
        if (hasMovieOneHourWithinRange(movieBookingInfo)) {
            throw new IllegalArgumentException("시간이 부적합힙니다.");
        }
        movieList.add(movieBookingInfo);
        movieBookingInfo.reserve();
    }

    private boolean hasMovieOneHourWithinRange(MovieBookingInfo movieBookingInfo) {
        for (MovieBookingInfo bookingInfo : movieList) {
            bookingInfo.isRangeWithinOneHour(movieBookingInfo);
        }

        return false;
    }

    public int getPrice() {
        int sum = 0;
        for (MovieBookingInfo m : movieList) {
            sum += m.getPrice();
        }
        return sum;
    }

    public List<MovieBookingInfo> getBookingList() {
        return new ArrayList<>(movieList);
    }


}
