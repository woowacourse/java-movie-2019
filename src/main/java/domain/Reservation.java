package domain;

public class Reservation {

    private final Movie movie;
    private final int scheduleNumber;

    public int getBuyCount() {
        return buyCount;
    }

    private final int buyCount;

    public Reservation(Movie movie, int scheduleNumber, int buyCount) {
        this.movie = movie;
        this.scheduleNumber = scheduleNumber;
        this.buyCount = buyCount;
        this.setMovieRepository();
    }

    private void setMovieRepository() {
        MovieRepository.buyMovieTickets(movie, scheduleNumber, buyCount);
    }

    public Movie getMovie() {
        return movie;
    }
}
