package domain;

/**
 * @author delf
 */
public class MovieBookingInfo {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int number;

    public MovieBookingInfo(Movie movie, PlaySchedule playSchedule, int number) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.number = number;
    }

    public int getPrice() {
        return movie.getPrice() * number;
    }

}


