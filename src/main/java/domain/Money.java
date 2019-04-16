package domain;

public class Money {

    private int money;
    private int point;

    public Money(int money,int point){
        this.money=money;
        this.point=point;
    }

    public int payment(){
        return this.money-this.point;
    }



}
