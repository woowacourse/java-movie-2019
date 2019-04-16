package domain;

public class MovieReservation {
    Movie movie;
    int scheduleNumber;
    int watcher;

    public MovieReservation(Movie movie, int scheduleNumber, int watcher) {
        this.movie = movie;
        this.scheduleNumber = scheduleNumber;
        this.watcher = watcher;
    }
}
