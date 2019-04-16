package domain;

public class Reservation {
    private final Movie movie;
    private final int peopleNumber;
    private final PlaySchedule playSchedule;

    public Reservation(Movie movie, int peopleNumber, PlaySchedule playSchedule) {
        this.movie = movie;
        this.peopleNumber = peopleNumber;
        this.playSchedule = playSchedule;
    }

    @Override
    public String toString() {
        return movie.toString() + playSchedule.toString() + peopleNumber;
    }
}
