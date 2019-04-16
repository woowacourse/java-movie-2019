package domain;

import java.util.List;

/**
 * @author delf
 */
public class UserInfo {
    private List<MovieBookingInfo> bookingList;
    private int point;

    public int  plusPoint(int n) {
        return (point += n);
    }

    public boolean hasMovieOneHourWithinRange(Movie movie) {
        for (MovieBookingInfo bookingInfo : bookingList) {

        }
        return false;
    }

    public int getPrice() {
        int sum = 0;
        for (MovieBookingInfo m : bookingList) {
            sum += m.getPrice();
        }
        return sum;
    }
}
