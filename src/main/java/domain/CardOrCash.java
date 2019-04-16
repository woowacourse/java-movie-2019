package domain;

public class CardOrCash {
    private final int cardOrCash;

    public CardOrCash(int cardOrCash){
        if(!(cardOrCash == 1 || cardOrCash == 2)){
            throw new IllegalArgumentException("신용카드는 1번, 현금은 2번입니다.");
        }
        this.cardOrCash = cardOrCash;
    }

    public int getCardOrCash() {
        return cardOrCash;
    }
}
