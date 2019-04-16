import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        int movieId;
        List<Reservation> reservations = new ArrayList<>();

        do {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            movieId = InputView.inputMovieId();
            OutputView.printPlaySchedule(movieId);
            int timeSchedule = InputView.inputTimeSchedule();
            int countOfBuy = InputView.inputCustomerNumber();
            reservations.add(new Reservation(movieId, timeSchedule, countOfBuy));
            OutputView.printPlaySchedule(movieId);
        } while (InputView.checkExit());

        //reservatoins 순회하면서
        List<MovieCost> movieCosts = new ArrayList<>();
        for (Reservation reservation : reservations) {
            movieCosts.add(new MovieCost(reservation));
        }
        // movieCost 만들고
        AllPay allPay = new AllPay(movieCosts);
        OutputView.printPayResult(allPay);
    }
}
