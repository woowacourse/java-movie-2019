package domain;

public class Reservation {
    private int movieId;
    private int movieTime;
    private int movieTicket;

    public Reservation(int movieId, int movieTime, int movieTicket) {
        this.movieId = movieId;
        this.movieTime = movieTime;
        this.movieTicket = movieTicket;
    }

    public int getMovieId() { return movieId; }
    public int getMovieTime() { return movieTime; }
    public int getMovieTicket() { return movieTicket; }
}
