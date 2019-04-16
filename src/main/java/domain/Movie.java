package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 영화를 관리하는 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
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

    public String movieInfoToString(){
        return id + " - " + name + ", " + price + "원";
    }

    public boolean isMatchedMovieId(int movieId){
        return movieId == this.id;
    }

    public boolean isOverPlaySchedule(int timeNum){
        return this.playSchedules.size() < timeNum;
    }

    public boolean isPossibleTime(int timeNum, int ReservationNum){
        return this.playSchedules.get(timeNum - 1).isPossibleReserve(ReservationNum);
    }

    public void updateMoviePlaySchedule(int selectedMoviePlayTime, int reservationNum){
        this.playSchedules.get(selectedMoviePlayTime - 1).updateCapacity(reservationNum);
    }
}
