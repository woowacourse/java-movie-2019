package domain;

public class MovieCost {
    private final int cost;

    public MovieCost(Reservation reservation) {
        Movie movie = reservation.getMovie();
        int count  = reservation.getBuyCount();

        cost = movie.getPrice() * count;
    }

    public int getCost() {
        return cost;
    }
}
