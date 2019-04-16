package domain;

public class CardOrCash {
    private static final double cardSale = 0.95;
    private static final double cashSale = 0.98;
    private final int cardOrCash;


    public CardOrCash(int cardOrCash) {
        if (!(cardOrCash == 1 || cardOrCash == 2)) {
            throw new IllegalArgumentException("신용카드는 1번, 현금은 2번입니다.");
        }
        this.cardOrCash = cardOrCash;
    }

    public int getCardOrCash() {
        return cardOrCash;
    }

    public int getResult(Point point, ReservateInformation reservateInformation) {
        int pointPrice = point.getPoint();
        int wholePrice = reservateInformation.getWholePrice();

        return CalculatePirce(wholePrice,pointPrice);
    }

    private int CalculatePirce(int wholePrice, int point) {
        if (this.cardOrCash == 1) {
            return (int) ((wholePrice - point) * 0.95);
        }
        return (int) ((wholePrice - point) * 0.98);
    }
}
