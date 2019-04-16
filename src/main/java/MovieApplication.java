import domain.*;
import utils.NaturalNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static final int CONTINUE_FLAG = 2;

    public static void main(String[] args) {
        showMovies();

	    ReservationRepository reservationRepository = new ReservationRepository();
	    do {
		    askReservation(reservationRepository);
	    } while (askContinue());
	    askPayment(reservationRepository);
    }

    private static void showMovies() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    private static void askReservation(ReservationRepository reservationRepository) {
	    Movie selectedMovie = askSelectMovie();
	    PlaySchedule selectedPlaySchedule = askContinue(selectedMovie);
	    int capacity = askCapacity(selectedPlaySchedule);

	    reservationRepository.addReservation(new Reservation(selectedMovie, selectedPlaySchedule, capacity));
    }

    private static Movie askSelectMovie() {
    	try {
		    Movie selectedMovie = MovieRepository.selectMovie(new NaturalNumber(InputView.inputMovieId()));
		    OutputView.printPlaySchedule(selectedMovie);
		    return selectedMovie;
	    } catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		return askSelectMovie();
	    }
    }

    private static PlaySchedule askContinue(Movie selectedMovie) {
	    int playScheduleNo = InputView.inputPlaySchedule();
	    return selectedMovie.getPlaySchedule(new NaturalNumber(playScheduleNo));
    }

    private static int askCapacity(PlaySchedule selectedPlaySchedule) {
	    return InputView.inputCapacity();
    }

    private static boolean askContinue() {
	    return InputView.inputContinueReservation() == CONTINUE_FLAG;
    }

    private static void askPayment(ReservationRepository reservationRepository) {
    	OutputView.printStartPayment();
    	InputView.inputPoint();
    	InputView.inputPayType();
    	OutputView.printPaymentResult(reservationRepository.getTotalPrice());
    }
}
