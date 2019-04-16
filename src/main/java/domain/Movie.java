/*
 * @(#)Movie.java
 *
 * v 0.0.0
 *
 * 2019.04.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 영화 정보를 가지고 있는 클래스
 *
 * @version 0.0.0
 * @author kwonmc, WoowahanTechCamp
 */
public class Movie {
    private static final char NEW_LINE = '\n';

    private static final String TIME_NOT_EXIST = "존재하지 않는 시간을 선택하셨습니다.";
    private static final String TIME_PASSED = "이미 지난 시간의 영화 입니다.";
    private static final String CAPACITY_NOT_ANYMORE = "예약 가능 인원이 없습니다.";
    private static final String CAPACITY_OVER = "예약 가능 인원 수를 초과하였습니다.";

    public static final int MINIMUM_CAPACITY = 1;

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isMovieId(int id) {
        return (this.id == id);
    }

    public void modifyMovieSchedule(int time, int reserveCount) {
        PlaySchedule playSchedule = playSchedules.get(time - 1);
        playSchedule.modifyCapacity(reserveCount);
    }

    public int isValidTime(int timeCode) {
        if (playSchedules.size() < timeCode) {
            throw new IllegalArgumentException(TIME_NOT_EXIST);
        }
        if (playSchedules.get(timeCode - 1).isNotPassedTime()) {
            throw new IllegalArgumentException(TIME_PASSED);
        }
        if (!playSchedules.get(timeCode - 1).isCapacityPossible(MINIMUM_CAPACITY)) {
            throw new IllegalArgumentException(CAPACITY_NOT_ANYMORE);
        }
        // TODO 다른 영화와 시간 차이를 검사하는 로직 필요함
        return timeCode;
    }

    public LocalDateTime getMovieLocalTime(int timeCode) {
        return playSchedules.get(timeCode - 1).getStartDateTime();
    }

    public int isValidCapacity(int id, int reserveCount) {
        if (!this.playSchedules.get(id - 1).isCapacityPossible(reserveCount)) {
            throw new IllegalArgumentException(CAPACITY_OVER);
        }
        return reserveCount;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    private PlaySchedule getPlayScheduleByTime(int time) {
        return playSchedules.get(time - 1);
    }

    public String toStringFromIdAndTime(int movieTime, int reserveCount) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + getPlayScheduleByTime(movieTime).toStringExceptCapacity()
                + "예약 인원: " + reserveCount + "명" + NEW_LINE;
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
