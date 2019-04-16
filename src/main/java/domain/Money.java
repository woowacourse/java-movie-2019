package domain;

public class Money {
    private int money;

    Money(int money,int point,int payment){
        if(payment==1){
            this.money=(int)((money-point)*0.95);
        }
        if(payment==2){
            this.money=(int)((money-point)*0.98);
        }

    }
}
