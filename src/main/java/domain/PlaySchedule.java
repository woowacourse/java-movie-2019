/*
 * @(#)PlaySchedule.java
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

import static utils.DateTimeUtils.format;

/**
 * 영화 하나의 플레이 스케줄을 담고 있는 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 */
public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void modifyCapacity(int reserveCount) {
        this.capacity -= reserveCount;
    }

    public boolean isCapacityPossible(int count) {
        return (this.capacity >= count);
    }

    public boolean isNotPassedTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return startDateTime.isBefore(currentTime);
    }

    public String toStringExceptCapacity() {
        return "시작시간: " + format(startDateTime) + "\n";
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
