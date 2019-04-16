import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    List<Movie> movies = MovieRepository.getMovies();
    List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        MovieApplication app = new MovieApplication();
        app.play();
    }

    private void play() {
        do {
            Reservation reservation = doReservation();
            reservations.add(reservation);
        } while (doAgain());
        printHistory();
        payment();
    }

    private Reservation doReservation() {
        System.out.println("## 상영 영화 목록");
        OutputView.printMovies(movies);
        int movieId = getMovieId();
        OutputView.printSelectedMovie(MovieRepository.getMovie(movieId));
        int movieTime = getMovieTime(movieId);
        int numOfGuest = getNumOfGuest(movieId, movieTime);
        return new Reservation(movieId, movieTime, numOfGuest);
    }

    private int getMovieId() {
        try {
            int movieId = InputView.inputMovieId();
            Validator.checkMovieId(movieId);
            return movieId;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieId();
        }
    }

    private int getMovieTime(int movieId) {
        try {
            int movieTime = InputView.inputMovieTime();
            Validator.checkMovieTime(movieId, movieTime);
            return movieTime;
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getMovieTime(movieId);
        }
    }

    private int getNumOfGuest(int movieId, int movieTime)  {
        try {
            int numOfGuest = InputView.inputNumOfGuest();
            Validator.checkNumOfGuest(movieId, movieTime, numOfGuest);
            return numOfGuest;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getNumOfGuest(movieId, movieTime);
        }
    }

    private boolean doAgain() {
        int quitOrDoAgain = getQuitOrDoAgain();
        return quitOrDoAgain == 2 ? true : false;
    }

    private int getQuitOrDoAgain() {
        try {
            int quitOrDoAgain = InputView.inputQuitOrDoAgain();
            Validator.checkQuitOrDoAgain(quitOrDoAgain);
            return quitOrDoAgain;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getQuitOrDoAgain();
        }
    }

    private void printHistory() {
        System.out.println("\n예약 내역");
        for (Reservation reservation : reservations) {
            reservation.printReservation();
            System.out.println();
        }
    }

    private void payment() {
        int totalPrice = getTotalPrice();
        System.out.println("## 결제를 진행합니다.");
        int point = getPoint(totalPrice);
        int totalPaymetPrice = finalPayment(totalPrice, point);
        OutputView.printPayment(totalPaymetPrice);
        // 결제 완료 후 예약가능인원 수정
    }

    private int getTotalPrice() {
        int totalPrice = 0;
        for (Reservation reservation : reservations) {
            totalPrice += reservation.getTicketPrice();
        }
        return totalPrice;
    }

    private int getPoint(int totalPrice) {
        try {
            int point = InputView.inputPoint();
            Validator.checkPoint(point, totalPrice);
            return point;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getPoint(totalPrice);
        }
    }

    private int finalPayment(int totalPrice, int point) {
        if (totalPrice == point) {
            return 0;
        }
        int balance = totalPrice - point;
        int totalPaymentPrice = cardOrCashPayment(balance);
        return totalPaymentPrice;
    }

    private int cardOrCashPayment(int balance) {
        int cardOrCash = getCardOrCash();
        if (cardOrCash == 1) {
            return (int) (balance * 0.95);
        }
        if (cardOrCash == 2) {
            return (int) (balance * 0.98);
        }
        return 0;
    }

    private int getCardOrCash() {
        try {
            int cardOrCash = InputView.inputCardOrCash();
            Validator.checkCardOrCash(cardOrCash);
            return cardOrCash;
        } catch (IllegalArgumentException e) {
            System.err.println("잘못 입력하셨습니다.");
            return getCardOrCash();
        }
    }
}