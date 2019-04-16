package domain;

import java.lang.String;

public class MovieReservation {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int watcher;

    public MovieReservation(Movie movie, PlaySchedule playSchedule, int watcher) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.watcher = watcher;
        movie.applyWatcher(watcher, playSchedule);
    }

    public void validateSchedule(PlaySchedule playSchedule) throws IllegalArgumentException {
        if(!this.playSchedule.canReserve(playSchedule)) {
            throw new IllegalArgumentException("예약 영화들 간의 상영 시작 시간 차이는 1시간 이내여야 합니다.");
        }
    }

    @Override
    public String toString() {
        String movieString = movie.toString().substring(0, movie.toString().indexOf("\n"));
        String playScheduleString = playSchedule.toString().substring(0, playSchedule.toString().indexOf("예"));
        return String.format("%s\n%s\n예약 인원: %d명\n", movieString, playScheduleString, watcher);
    }

    public int getPrice() {
        return movie.getPrice(watcher);
    }
}
