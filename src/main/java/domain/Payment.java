package domain;

public class Payment {

    private int method;
    private int point;
    private long amountOfPayment;

    public Payment(int method, int point, long amountOfPayment){
        this.method = method;
        this.point = point;
        this.amountOfPayment = amountOfPayment;
    }

    public long getAmountOfPayment(){
        if(method == 1){
            return getAmountOfCreditCardPayment();
        }
        return getAmountOfCashPayment();
    }

    public long getAmountOfCreditCardPayment(){
        long totalAmount = amountOfPayment - point;
        return totalAmount - ((long)(totalAmount*0.05));
    }

    public long getAmountOfCashPayment(){
        long totalAmount = amountOfPayment - point;
        return totalAmount - ((long)(totalAmount*0.02));
    }

    public String toString(){
        return "최종 결제 금액은 "+getAmountOfPayment()+"원 입니다";
    }
}
