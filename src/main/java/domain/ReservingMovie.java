package domain;

public class ReservingMovie {
    private final Movie movie;
    private final int startTime;
    private final int numberOfPeople;

    public ReservingMovie(Movie movie, int startTime, int numberOfPeople) {
        this.movie = movie;
        this.startTime = startTime;
        this.numberOfPeople = numberOfPeople;
    }

    public int getPrice() {
        return movie.getPrice() * numberOfPeople;
    }

    @Override
    public String toString() {
        return movie.selectedMovieInfo(startTime, numberOfPeople);
    }
}