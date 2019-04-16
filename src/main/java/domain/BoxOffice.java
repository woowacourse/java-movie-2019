package domain;

import java.time.LocalDateTime;

public class BoxOffice {
    private Movie selectMovie;
    private Result result;

    public BoxOffice(Movie selectMovie) {
        this.selectMovie = selectMovie;
        this.result = new Result();
    }

    public PlaySchedule selectSchedule(int selectMovieSchedule, int peopleCount, LocalDateTime currentTime) {
        PlaySchedule selectSchedule = selectMovie.select(selectMovieSchedule);
        if (selectSchedule.isValidSchdule(currentTime)) {
            selectSchedule.buy(peopleCount);
        }
        return selectSchedule;
    }


}
