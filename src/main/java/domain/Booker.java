package domain;

import org.w3c.dom.ls.LSInput;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Booker {
    private static final double SALE_CARD = 0.95;
    private static final double SALE_MONEY = 0.98;
    private static final int PAYMENT_TYPE_CARD = 1;

    private List<Movie> bookingMovies;
    private List<Integer> bookingTime;
    private List<Integer> bookingNumber;

    private int tryBookingNumber = 0;

    public Booker() {
        bookingMovies = new ArrayList<>();
        bookingTime = new ArrayList<>();
        bookingNumber = new ArrayList<>();
    }

    public void selectMovie() {
        bookingMovies.add(MovieRepository.getMovie(InputView.inputMovieId()));
    }

    public void selectBookingTime() {
        bookingTime.add(InputView.inputBookingTime(bookingMovies.get(tryBookingNumber)));
    }

    public void selectBookingNumber() {
        bookingNumber.add(InputView.inputBookingNumber(bookingMovies.get(tryBookingNumber), bookingTime.get(0)));
        tryBookingNumber++;
    }

    public int currentBookingMovieId() {
        return bookingMovies.get(tryBookingNumber).getId();
    }


    public List<String> printResult() {
        List<String> resultBooking = new ArrayList<>();
        String str = "";
        for (int i = 0; i < tryBookingNumber; i++) {
            str = bookingMovies.get(i).toStringMovie();
            str += bookingMovies.get(i).toStringPlaySchedule(bookingTime.get(i));
            str += "예약 인원: " + bookingNumber.get(i) + "명";
            resultBooking.add(str);
        }
        return resultBooking;
    }

    public int getTotalPrice(int paymentType, int point) {
        int totalPrice = 0;
        for (int i = 0; i < tryBookingNumber; i++) {
            totalPrice = bookingMovies.get(i).getPrice();
            totalPrice *= bookingNumber.get(i);
        }
        totalPrice -= point;
        if (paymentType == PAYMENT_TYPE_CARD) {
            return (int) (totalPrice * SALE_CARD);
        }
        return (int) (totalPrice * SALE_MONEY);
    }
}
