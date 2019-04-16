import domain.Movie;
import domain.MovieRepository;

import domain.ReservedMovie;
import input.*;
import view.InputView;
import view.OutputView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<ReservedMovie> reservedMovies = new ArrayList<ReservedMovie>();

        start(reservedMovies);
        doPurchase(reservedMovies);
    }

    private static void start(List<ReservedMovie> reservedMovies) {
        choose(reservedMovies);
        Continue choice = InputView.askContinuePurchaseOrNot();
        OutputView.printReservedMovies(reservedMovies);
        if (choice == Continue.YES) {
            start(reservedMovies);
        }
    }

    private static void choose(List<ReservedMovie> reservedMovies) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie movie = InputView.inputMovie(movies);
        OutputView.printMovies(movie);

        int scheduleId = InputView.getScheduleId(movie, reservedMovies);
        int memberNumber = InputView.getMemberNumber(movie, scheduleId);
        reservedMovies.add(new ReservedMovie(movie,scheduleId,memberNumber));
    }

    private static int calculatePurchaseAmount(double discountRate,
                                        int bonusPoint, int originalAmount) {
        double purchaseAmount = originalAmount - bonusPoint;
        int purchaseAmountToInteger = (int)(purchaseAmount - purchaseAmount * discountRate);
        return purchaseAmountToInteger;
    }

    private static void doPurchase(List<ReservedMovie> reservedMovies) {
        int bonusPoint = InputView.getPoint(reservedMovies);
        double discountRate = InputView.getDiscountRate();
        int originalAmount = Point.getCostFromReservedList(reservedMovies);
        int purchaseAmount = calculatePurchaseAmount(discountRate, bonusPoint,
                originalAmount);

        OutputView.printPurchaseAmount(purchaseAmount);

    }


}
