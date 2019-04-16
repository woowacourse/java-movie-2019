package domain;

import view.InputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public boolean isMatchMovieId(int movieId) {
        return movieId == this.id;
    }

    public boolean isCorrectScheduleId(int scheduleId) {
        boolean result = scheduleId <= playSchedules.size();
        if (!result) {
            System.out.println(InputView.OVER_RANGE_SCHEUDLE);
        }
        return result;
    }

    public boolean isPossibleWatch(int scheduleId) {
        PlaySchedule userSelectSchedule = playSchedules.get(scheduleId - 1);
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.isBefore(userSelectSchedule.getStartDateTime());
    }

    public boolean isImpossibleSchedule(List<Reserve> reserveList, int scheduleId) {
        boolean result = false;
        PlaySchedule userSelectSchedule = playSchedules.get(scheduleId - 1);
        for (Reserve reserve : reserveList) {
            result = result || !isOneHourWithinRange(reserve.getSchedule().getStartDateTime(), userSelectSchedule.getStartDateTime());
        }
        if (result) {
            System.out.println(InputView.OVER_ONEHOUR);
        }
        return result;
    }

    public boolean isImpossibleMovie(List<Reserve> reserveList) {
        boolean result = false;
        if (reserveList.size() == 0)
            return false;
        for (Reserve reserve : reserveList) {
            result = result || searchOneHourRangeSchedule(reserve);
        }
        if (!result)
            System.out.println(InputView.IMPOSSIBLE_MOVIE);
        return !result;
    }

    public boolean searchPossibleAllSchedule() {
        boolean result = false;
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (PlaySchedule playSchedules : playSchedules) {
            result = result || currentDateTime.isBefore(playSchedules.getStartDateTime());
        }
        if (!result)
            System.out.println(InputView.IMPOSSIBLE_MOVIE);
        return result;
    }

    private boolean searchOneHourRangeSchedule(Reserve reserve) {
        boolean result = false;
        for (PlaySchedule playSchedule : playSchedules) {
            result = result || isOneHourWithinRange(reserve.getSchedule().getStartDateTime(), playSchedule.getStartDateTime());
        }
        return result;
    }

    public PlaySchedule getSchedule(int scheduleId) {
        return playSchedules.get(scheduleId - 1);
    }

    void printMovieInformation() {
        System.out.println(id + " - " + name + ", " + price + "원");
    }

    int getPrice() {
        return price;
    }
}
