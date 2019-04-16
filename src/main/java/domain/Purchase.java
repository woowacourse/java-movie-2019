package domain;

public class Purchase {

    private int totalPrice;

    public Purchase(int totalPrice){
        this.totalPrice = totalPrice;
    }

    public void printTotalPrice(){
        System.out.println(totalPrice);
    }
}
