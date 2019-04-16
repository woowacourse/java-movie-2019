package domain;

public class Point {
    private final int point;

    public Point(ReservateInformation reservateInformation, int point){
        if(reservateInformation.getWholePrice() <  point){
            throw new IllegalArgumentException("포인트는 금액을 넘을 수 없습니다.");
        }

        this.point = point;
    }
}
