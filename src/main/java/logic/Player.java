package logic;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Reservation> reservations;
    private List<MovieCost> movieCosts;

    public Player() {
        reservations = new ArrayList<>();
        movieCosts = new ArrayList<>();
    }

    public void play() {
        if (!MovieRepository.isAllMoviePossible()) {
            return;
        }
        do {
            Movie movie = InputView.inputMovie();
            BuyWithTimeschedule(movie);
            System.out.println("확인");
            OutputView.printPlaySchedule(movie);
        } while (checkContinue() && MovieRepository.isAllMoviePossible());
    }

    private boolean checkContinue() {
        return InputView.inputContinue().isTwo();
    }

    private void BuyWithTimeschedule(Movie movie) {
        try {
            OutputView.printPlaySchedule(movie);
            int timeScheduleIndex = InputView.InputTimeScheduleIndex(movie);
            int countOfBuy = InputView.inputCustomerBuyCount();
            checkReservationAndAdd(movie, timeScheduleIndex, countOfBuy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            BuyWithTimeschedule(movie);
        }
    }

    private void checkReservationAndAdd(Movie movie, int timeScheduleIndex, int countOfBuy) {
        for (Reservation reservation : reservations) {
            reservation.isMatchInOneHour(timeScheduleIndex);
        }
        reservations.add(new Reservation(movie, timeScheduleIndex, countOfBuy));
    }

    public void calculateCost() {
        for (Reservation reservation : reservations) {
            movieCosts.add(new MovieCost(reservation));
        }
        AllPay allPay = new AllPay(movieCosts);
        OutputView.printPayResult(allPay);
    }
}
