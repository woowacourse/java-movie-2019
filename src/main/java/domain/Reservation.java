package domain;

public class Reservation {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int theNumberOfPerson;

    public Reservation(Movie movie, PlaySchedule playSchedule, int theNumberOfPerson) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.theNumberOfPerson = theNumberOfPerson;
    }

    @Override
    public String toString() {
        return "예약 내역" + "\n" +
                movie.toStringOnlyMovieField() +
                playSchedule.toString() +
                "예약인원 : " + theNumberOfPerson + "명" + "\n";
    }
}
