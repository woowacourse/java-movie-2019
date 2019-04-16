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

    public void init() {

    }

    public void play() {
        do {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Movie movie = InputView.inputMovie();
            OutputView.printPlaySchedule(movie);
            int timeSchedule = InputView.InputTimeScheduleIndex();
            int countOfBuy = InputView.inputCustomerBuyCount();
            reservations.add(new Reservation(movie, timeSchedule, countOfBuy));
            OutputView.printPlaySchedule(movie);    // 테스트할때만 쓰는거 나중에 지울것
        } while (InputView.checkExit());

        //reservatoins 순회하면서
        for (Reservation reservation : reservations) {
            movieCosts.add(new MovieCost(reservation));
        }
        AllPay allPay = new AllPay(movieCosts);
        OutputView.printPayResult(allPay);
    }
}
