package Program;

import Program.Config.Validation;
import domain.BookMovie;
import domain.Movie;
import domain.User;
import view.InputView;
import view.OutputView;



public class PaymentSystem {
    private double totalPrice;
    private User user;
    public PaymentSystem(){
        this.user = new User();
        this.totalPrice = 0.0;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void paymentStart(BookMovie bookMovie, int type){
        try {
            Validation.checkPaymentType(type);
            OutputView.printPaymentStart();
            double price = countInitTotalPrice(bookMovie);
            double point = InputView.inputPoint();
            addPrice(price);
            salePrice(type);
            usePoint(point);
        }catch(Exception e){
            System.out.println("없는 결제 수단입니다.");
            paymentStart(bookMovie, InputView.inputPaymentType());
        }
    }

    private double countInitTotalPrice(BookMovie bookMovie){
        totalPrice = bookMovie.getBookingPeople() * bookMovie.getBookMovieList().get(0).getprice();
        return totalPrice;
    }

    private void usePoint(double usePoint){
        if(user.getPoint()>=usePoint) {
            totalPrice = totalPrice - usePoint;
            user.usePointforPayment(usePoint);
        }
    }

    private void addPrice(double price){
        totalPrice += price;
    }

    private void salePrice(int type){
        if(type == 1){
            totalPrice = totalPrice - (totalPrice * 0.05);
            return;
        }
        if(type == 2){
            totalPrice = totalPrice - (totalPrice * 0.02);
            return;
        }
    }
}
