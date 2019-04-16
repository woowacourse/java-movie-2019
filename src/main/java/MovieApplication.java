import domain.*;
import utils.NaturalNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	private static final int CONTINUE_FLAG = 2;

    public static void main(String[] args) {
	    ReservationRepository reservationRepository = new ReservationRepository();
	    do {
		    askReservation(reservationRepository);
	    } while (askContinue());
	    Payment payment = new Payment(reservationRepository);
	    askPayment(payment);

    }

    private static void showMovies() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private static void askReservation(ReservationRepository reservationRepository) {
    	try {
		    Movie selectedMovie = askSelectMovie();
		    PlaySchedule selectedPlaySchedule = askPlaySchedule(selectedMovie);
		    int capacity = askCapacity(selectedPlaySchedule);
		    reservationRepository.addReservation(new Reservation(selectedMovie, selectedPlaySchedule, capacity));
	    } catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		askReservation(reservationRepository);
	    }
    }

    private static Movie askSelectMovie() {
    	try {
		    showMovies();
		    Movie selectedMovie = MovieRepository.selectMovie(new NaturalNumber(InputView.inputMovieId()));
		    OutputView.printPlaySchedule(selectedMovie);
		    return selectedMovie;
	    } catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		return askSelectMovie();
	    }
    }

    private static PlaySchedule askPlaySchedule(Movie selectedMovie) {
    	try {
		    int playScheduleNo = InputView.inputPlaySchedule();
		    return selectedMovie.getPlaySchedule(new NaturalNumber(playScheduleNo));
	    } catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		return askPlaySchedule(selectedMovie);
	    }
    }

    private static int askCapacity(PlaySchedule selectedPlaySchedule) {
    	int capacity = 0;
    	do {
		    capacity = InputView.inputCapacity();
	    } while (!selectedPlaySchedule.isCapacity(capacity));
    	return capacity;
    }

    private static boolean askContinue() {
	    return InputView.inputContinueReservation() == CONTINUE_FLAG;
    }

    private static void askPayment(Payment payment) {
    	OutputView.printStartPayment();
    	askPoint(payment);
	    int payPrice = askPay(payment);
    	OutputView.printPaymentResult(payPrice);
    }

    private static int askPoint(Payment payment) {
    	try {
    		int point = InputView.inputPoint();
    		payment.payPoint(new NaturalNumber(point));
    		return point;
	    } catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		return askPoint(payment);
	    }
    }

    private static int askPay(Payment payment) {
	    try {
		    return payment.pay(new NaturalNumber(InputView.inputPayType()));
	    } catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		    return askPoint(payment);
	    }
    }
}
