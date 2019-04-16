package domain;

class Point {
    private final int point;

    Point(int point) {
        if (point < 0) {
            throw new IllegalArgumentException("반드시 0 이상의 숫자로 포인트를 입력하세요!");
        }
        this.point = point;
    }

    int discountAmount(int price) {
        if (point > price) {
            return 0;
        }
        return (price - point);
    }
}
