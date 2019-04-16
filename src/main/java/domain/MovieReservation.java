package domain;

public class MovieReservation {
    Movie movie;
    PlaySchedule playSchedule;
    int watcher;

    public MovieReservation(Movie movie, PlaySchedule playSchedule, int watcher) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.watcher = watcher;
        movie.applyWatcher(watcher, playSchedule);
    }

    public void validateSchedule(PlaySchedule playSchedule) throws IllegalArgumentException{
        if(!this.playSchedule.canReserve(playSchedule)) {
            throw new IllegalArgumentException("예약 영화들 간의 상영 시작 시간 차이는 1시간 이내여야 합니다.");
        }
    }
}
