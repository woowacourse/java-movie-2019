package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static domain.MovieRepository.ONE;

public class Movie {
    public static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSelectedMovie(int movieId) {
        return this.id == movieId;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public void reserveMovie(int movieTime, int numberOfPeople) {
        playSchedules.get(movieTime - ONE).decreaseCapacity(numberOfPeople);
    }

    public LocalDateTime getReserveMovieTime(int movieTime) {
        return playSchedules.get(movieTime - ONE).getStartDateTime();
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
}
