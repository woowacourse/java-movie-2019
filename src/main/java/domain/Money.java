package domain;

public class Money {
    private int money;

    Money(int money){
        this.money=money;
    }

    public void addMoney(int money){
        this.money+=money;
    }

    public void substractMoney(int point){
        money-=point;
    }
}
