package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class UserInfo {
    private final static int DEFAULT_POINT = 10_000;

    private List<MovieBookingInfo> bookingList = new ArrayList<>();
    private int point = DEFAULT_POINT;

    public int  plusPoint(int n) {
        return (point += n);
    }

    public int getPoint() {
        return point;
    }

    public void addMove(MovieBookingInfo movieBookingInfo) {
        bookingList.add(movieBookingInfo);
    }

    private boolean hasMovieOneHourWithinRange(Movie movie) {
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

    public List<MovieBookingInfo> getBookingList() {
        return this.bookingList;
    }

}
