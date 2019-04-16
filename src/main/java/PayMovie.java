import domain.Movie;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayMovie {
    private static final double CASH_DISCOUNT = 0.98;
    private static final double CARD_DISCOUNT = 0.95;
    private final List<Movie> bookedMovies;

    PayMovie(List<Movie> bookedMovies) {
        this.bookedMovies = bookedMovies;
        showBookedMovies();
    }

    private void showBookedMovies() {
        OutputView.printPayInfo(bookedMovies);
    }

    public void run() {
        try {
            int totalPayMoney = activateDisCount(makePayAmount(getPointAmount()));
            OutputView.printPayResult(totalPayMoney);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            run();
        }
    }

    private int getPointAmount() {
        int payMoney = InputView.inputPointAmount();
        if (payMoney < 0){
            return 0;
        }
        return payMoney;
    }

    private int makePayAmount(int point) {
        int payMoney = 0;
        for (Movie m : bookedMovies) {
            payMoney += m.getPrice();
        }
        return payMoney - point;
    }

    private int activateDisCount(int preDiscountedMoney) {
        if (InputView.inputCardOrCash()) {
            return activateDisCountCard(preDiscountedMoney);
        }
        return activateDisCountCash(preDiscountedMoney);
    }

    private int activateDisCountCard(int money) {
        return (int) (money * CARD_DISCOUNT);
    }

    private int activateDisCountCash(int money) {
        return (int) (money * CASH_DISCOUNT);
    }

}
