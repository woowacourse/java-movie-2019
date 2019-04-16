package domain;

public class Money {
    private int money;

    Money(int money){
        this.money=money;
    }
    public String toString() {
        return "최종 결제한 금액은"+money+"원 입니다.";
    }

    public void addMoney(int money){
        this.money+=money;
    }

    public void substractMoney(int point){
        money-=point;
    }
    public void salePrice(int payment){
        if(payment==1){
            money=(int)(money*0.95);
        }
        if(payment==2){
            money=(int)(money*0.98);
        }
    }


}
