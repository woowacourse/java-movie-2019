/*
 *  @(#)Reservation.java       1.00    2019/04/16
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class Reservation {

    private int movieId;
    private int scheduleNumber;
    private int numberOfPeople;

    public Reservation(int movieId, int scheduleNumber, int numberOfPeople) {
        this.movieId = movieId;
        this.scheduleNumber = scheduleNumber;
        if (numberOfPeople > MovieRepository.getMovieById(movieId).getPlaySchedule(scheduleNumber).getCapacity()) {
            throw new IllegalArgumentException
                    ("예약 가능 인원보다 더 많은 예약인원을 입력하였습니다.");
        }
        this.numberOfPeople = numberOfPeople;
    }

    /* 영화표 가격 X 사람 수   => 가격 계산 */
    public int price() {
        return MovieRepository.getMovieById(movieId).getPrice() * this.numberOfPeople;
    }

    /* 시작 시간 반환*/
    public LocalDateTime getStartTime() {
        return MovieRepository.getMovieById(movieId).getPlaySchedule(scheduleNumber).getStartDateTime();
    }

    @Override
    public String toString() {
        Movie movie = MovieRepository.getMovieById(movieId);
        return movie.getId() + " - " + movie.getName() + " , " + movie.getPrice() + "원\n"
                + "시작시간: " + format(this.getStartTime()) + "\n예약인원: " + this.numberOfPeople + "\n";
    }

}
