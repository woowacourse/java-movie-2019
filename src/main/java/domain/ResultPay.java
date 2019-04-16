package domain;

public class ResultPay {
    private static final int MIN_POINT = 0;
    int pay;
    int point;

    public ResultPay(int pay, int point) {
        this.pay = pay;
        this.point = point;
    }

    public static int checkPoint(int point) {
        if (point < MIN_POINT) {
            throw new IllegalArgumentException();
        }
        return point;
    }

}
