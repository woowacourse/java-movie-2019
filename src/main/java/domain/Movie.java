package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static domain.MovieRepository.ONE;

public class Movie {
    public static final char NEW_LINE = '\n';
    private static final String INTPUT_TIME_ERROR_MENT = "정확한 예매 시간을 입력하세요";
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
        try {
            checkValidateTime(movieTime);
            checkValidateNumberOfPeople(movieTime, numberOfPeople);
            playSchedules.get(movieTime - ONE).decreaseCapacity(numberOfPeople);
        } catch (Exception e) {
            throw new IllegalArgumentException(INTPUT_TIME_ERROR_MENT);
        }
    }

    private void checkValidateNumberOfPeople(int movieTime, int numberOfPeople) {
        if (numberOfPeople > playSchedules.get(movieTime - ONE).getCapacity()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValidateTime(int movieTime) {
        if (movieTime < 1 || movieTime > playSchedules.size()) {
            throw new IllegalArgumentException();
        }
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
