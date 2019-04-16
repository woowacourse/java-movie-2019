/*
 * @(#)ReservationList.java
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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.DateTimeUtils;

/**
 * 예약 내역, 수량과 시간을 담는 리스트 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 */
public class ReservationList {
    private Map<Movie, Integer> reservationCountList = new HashMap<>();
    private Map<Movie, Integer> reservationTimeList = new HashMap<>();

    public void add(Movie movie, Integer count, Integer timeCode) {
//        if (addMovieTimeValidator(movie, timeCode)) {
        reservationCountList.put(movie, count);
        reservationTimeList.put(movie, timeCode);
//        }
    }

//    public boolean addMovieTimeValidator(Movie newMovie, Integer newTimeCode) {
//        for (Movie movie : reservationTimeList.keySet()) {
//            Integer timeCode = reservationTimeList.get(movie);
//            if (!DateTimeUtils.isOneHourWithinRange(movie.getMovieLocalTime(timeCode), newMovie.getMovieLocalTime(newTimeCode))) {
//                System.out.println("한 시간 이내의 영화를 선택해야 합니다.");
//                return false;
//            }
//        }
//        return true;
//    }

    public Set<Movie> getMovieSet() {
        return this.reservationCountList.keySet();
    }

    public Integer getCountByMovie(Movie movie) {
        return reservationCountList.get(movie);
    }

    public Integer getTimeByMovie(Movie movie) {
        return reservationTimeList.get(movie);
    }

    int getTotalPrice() {
        int totalPrice = 0;
        for (Movie movie : reservationCountList.keySet()) {
            int eachPrice = movie.getPrice() * reservationCountList.get(movie);
            totalPrice += eachPrice;
        }
        return totalPrice;
    }
}
