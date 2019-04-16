package domain;

public class Payment {
    private static final char NEW_LINE = '\n';

    private ReserveMovie reserveMovie;
    private int paymentType;
    private int userPoint;

    public Payment(ReserveMovie reserveMovie, int paymentType, int userPoint) {
        this.reserveMovie = reserveMovie;
        this.paymentType = paymentType;
        this.userPoint = userPoint;
    }


    private int calculatePrice(){
        if (paymentType == 1){//카드결제
            return creditCardPrice();
        }
        return cashPrice();
    }

    private int creditCardPrice(){
        return (int) Math.round((double)((reserveMovie.getMovie().getPrice() * reserveMovie.getReservePersonCount()) - userPoint) * 0.95);
    }

    private int cashPrice(){
        return (int) Math.round((double)((reserveMovie.getMovie().getPrice() * reserveMovie.getReservePersonCount()) - userPoint) * 0.98);
    }

    @Override
    public String toString() {
        return "최종 결제한 금액은 " + calculatePrice() + "원 입니다." + NEW_LINE
                + "예매를 완료했습니다. 즐거운 영화 관람되세요." ;
    }
}
