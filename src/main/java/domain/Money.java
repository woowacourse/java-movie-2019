package domain;

public class Money {
    private final static int CARD = 1;

    private long money;

    public Money(long money){
       this.money = money;
    }

    public boolean isValidMoney(int point){
       if(money - point < 0){
           return false;
       }
       return true;
    }

    public void calculatePoint(long point){
       this.money = this.money - point;
    }

    public void calculateTotalMoney(int payment) {
        if(payment == CARD){
            this.money = (Math.round(money * 0.95));
        }
        this.money = (Math.round(money * 0.98));
    }

    public String printTotalMoney(){
        return "최종 결제한 금액은 "+ money +"원 입니다.";
    }
}
