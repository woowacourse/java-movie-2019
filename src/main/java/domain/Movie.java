package domain;

import view.InputView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static utils.DateTimeUtils.createDateTime;
import static utils.DateTimeUtils.isOneHourWithinRange;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
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
    public boolean isMatchMovieId(int movieId){
        return movieId == this.id;
    }
    public boolean isCorrectSheduleId(int shceduleId){
        try {
            PlaySchedule userSelectSchedule = playSchedules.get(shceduleId - 1);
            return true;
        } catch (IndexOutOfBoundsException ex){
            System.out.println(InputView.OVER_RANGE_SCHEUDLE);
            return false;
        }
    }
    public boolean isPossibleWatch(int scheduleId){
        PlaySchedule userSelectSchedule = playSchedules.get(scheduleId - 1);
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.isBefore(userSelectSchedule.getStartDateTime());
    }
}
