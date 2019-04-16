package domain;

public class Reservation {
    private Movie movie;
    private int schedule;
    private int peopleNum;

    public Reservation(Movie movie, int schedule, int peopleNum) {
        this.movie = movie;
        this.schedule = schedule;
        this.peopleNum = peopleNum;
    }

    @Override
    public String toString() {
        return movie.getInformation() + "예약 인원:" + peopleNum + "명\n";
    }
}
