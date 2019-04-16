package domain;

import java.time.LocalDateTime;
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
        return toStringMovie() + sb.toString();
    }

    String toStringMovie(){
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
    }

    String toStringPlaySchedule(int bookingTime){
        return playSchedules.get(bookingTime).toString();
    }

    int getId() {
        return id;
    }

    boolean isSameMovieId(int movieId) {
        return (id == movieId);
    }

    public boolean isContainSchedule(int bookingTime) {
        return ((MIN_TIME <= bookingTime) && (bookingTime < playSchedules.size()));
    }

    public LocalDateTime getShowTime(int bookingTime){
        return playSchedules.get(bookingTime).getStartDateTime();
    }

    public boolean isValidityBookingNumber(int bookingTime, int bookingNumber){
        return playSchedules.get(bookingTime).isValidityCapacity(bookingNumber);
    }
}
