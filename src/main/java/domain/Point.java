package domain;

public class Point {
    private static final int POINT_MINIMUM = 0;

    private final int point;

    public Point(int point) {
        if (point < POINT_MINIMUM) {
            throw new IllegalArgumentException("0 이상의 수를 입력해야 합니다.");
        }
        this.point = point;
    }

    public int getMoviePriceWithoutPoint(int totalMoviePrice) {
        int remainedPrice = totalMoviePrice - point;
        return (remainedPrice < 0) ? 0 : remainedPrice;
    }
}
