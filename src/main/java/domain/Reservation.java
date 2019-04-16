package domain;

public class Reservation {
    private static final char NEW_LINE = '\n';

    Movie movie;
    int tableId;
    int numPeople;

    public Reservation(Movie movie, int tableId, int numPeople) {
        this.movie = movie;
        this.tableId = tableId;
        this.numPeople = numPeople;
    }

    @Override
    public String toString() {
        return movie.toString(tableId) + NEW_LINE + "예약 인원: " + numPeople + "명" + NEW_LINE;
    }
}
