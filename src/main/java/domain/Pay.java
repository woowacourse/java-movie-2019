package domain;

public class Pay {
    private final Point point;
    private final int totalMoviePrice;

    public Pay(Point point, int totalMoviePrice) {
        this.point = point;
        this.totalMoviePrice = totalMoviePrice;
    }

    public int getPaymentPrice(int paymentMethod) {
        return (paymentMethod == 1) ? payCreditCard() : payCash();
    }

    private int payCreditCard() {
        int remainedPrice = point.getMoviePriceWithoutPoint(totalMoviePrice);
        remainedPrice -= (int) ((double) remainedPrice * 0.05);
        return remainedPrice;
    }

    private int payCash() {
        int remainedPrice = point.getMoviePriceWithoutPoint(totalMoviePrice);
        remainedPrice -= (int) ((double) remainedPrice * 0.02);
        return remainedPrice;
    }
}
