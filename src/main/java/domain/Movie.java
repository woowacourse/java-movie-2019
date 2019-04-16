package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int MIN_TIME = 1;

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    int getId() {
        return id;
    }

    boolean isSameMovieId(int movieId) {
        return (id == movieId);
    }

    public boolean isContainSchedule(int reservationTime) {
        return ((MIN_TIME <= reservationTime) && (reservationTime < playSchedules.size()));
    }

    public boolean isValidityBookingNumber(int bookingTime, int bookingNumber){
        return playSchedules.get(bookingTime).isValidityCapacity(bookingNumber);
    }
}
