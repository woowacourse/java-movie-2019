package domain;

public class MoviePoint {
    public static final int MIN_POINT = 0;
    private int moviePoint;

    public MoviePoint(int moviePoint) {
        if (moviePoint < MIN_POINT) {
            throw new IllegalArgumentException("포인트는 0점 이상의 숫자입니다. 입력을 확인해 주세요.");
        }
        this.moviePoint = moviePoint;
    }

    public int getMoviePoint() {
        return moviePoint;
    }
}
