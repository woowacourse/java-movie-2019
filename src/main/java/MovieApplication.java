import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {

    private static final int NOT_EXIST_NUMBER = -1;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<ReservedMovie> reservedMovies = new ArrayList<>();
        int check = 2;
        while (check == 2) {
            movieReserve(movies, reservedMovies);
            check = getContinueReserve();
        }
        OutputView.printReservedMovies(reservedMovies);
        OutputView.printStartPayment();
        Payment payment = calculatePrice(reservedMovies);
        payment.applyPoint(getUsagePoint());
        payment.calculatePaymentTypeDiscount(getPaymentType());
        reserveEnd(payment);
    }

    private static void movieReserve(List<Movie> movies, List<ReservedMovie> reservedMovies){
        Movie reserveMovie = getReserveMovie(movies);
        OutputView.printMovie(reserveMovie);
        PlaySchedule reserveSchedule = getValidSchedule(reservedMovies, reserveMovie);
        if (reserveSchedule == null) {
            return;
        }
        int reserveAmount = getReserveAmount(reserveSchedule);
        reservedMovies.add(new ReservedMovie(reserveMovie,
                reserveSchedule.getStartDateTime(), reserveAmount));
    }
    private static int getValidMovieId(List<Movie> movies) {
        OutputView.printMovies(movies);
        try {
            int movieId = InputView.inputMovieId();
            return movieId;
        } catch (InputMismatchException e) {
            OutputView.printMisMatchInputType();
            InputView.makeLine();
            return getValidMovieId(movies);
        }
    }

    private static Movie getReserveMovie(List<Movie> movies) {
        int validMovieId = NOT_EXIST_NUMBER;
        do {
            validMovieId = getValidMovieId(movies);
        } while (!MovieValidator.isExistMovie(validMovieId));
        return MovieRepository.getMovie(validMovieId);
    }

    private static PlaySchedule getValidSchedule
            (List<ReservedMovie> reservedMovies, Movie movie) {
        int scheduleNumber = NOT_EXIST_NUMBER;
        try {
            scheduleNumber = InputView.inputScheduleNumber();
            PlaySchedule schedule = movie.getPlaySchedule(scheduleNumber);
            if (!MovieValidator.scheduleValidate(reservedMovies, schedule)){
                return null;
            }
            return schedule;
        } catch (IndexOutOfBoundsException e) {
            OutputView.printNotExistSchedule(scheduleNumber);
            return getValidSchedule(reservedMovies, movie);
        }
    }

    private static int getReserveAmount(PlaySchedule schedule) {
        int reserveAmount = NOT_EXIST_NUMBER;
        do {
            reserveAmount = InputView.inputReserveNumber();
        } while (!schedule.isPossibleReserve(reserveAmount));
        schedule.reserve(reserveAmount);
        return reserveAmount;
    }

    private static int getContinueReserve(){
        int continueCheck = NOT_EXIST_NUMBER;
        do {
            continueCheck = InputView.isContinueReserve();
        } while (!MovieValidator.isValidContinueInput(continueCheck));
        return continueCheck;
    }

    private static Payment calculatePrice(List<ReservedMovie> reservedMovies){
        int totalPrice = 0;
        for (ReservedMovie reservedMovie : reservedMovies){
            totalPrice += reservedMovie.getPrice();
        }
        return new Payment(totalPrice);
    }

    private static int getUsagePoint(){
        int point = NOT_EXIST_NUMBER;
        do {
            point = InputView.inputPoint();
        } while (!MovieValidator.pointValidate(point));
        return point;
    }

    private static int getPaymentType(){
        int paymentType = NOT_EXIST_NUMBER;
        do {
            paymentType = InputView.selectPaymentType();
        } while (!MovieValidator.paymentTypeValidate(paymentType));
        return paymentType;
    }

    private static void reserveEnd(Payment payment){
        InputView.closeScanner();
        OutputView.printClosing(payment);
    }
}
