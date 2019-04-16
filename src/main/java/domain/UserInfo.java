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
        movieList.add(movieBookingInfo);
    }

    private boolean hasMovieOneHourWithinRange(PlaySchedule playSchedule) {
        for (MovieBookingInfo bookingInfo : movieList) {
            bookingInfo.isRangeWithinOneHour(playSchedule);
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
