import com.sun.scenario.effect.impl.sw.java.JSWBlend_MULTIPLYPeer;
import domain.*;
import jdk.nashorn.internal.ir.visitor.NodeVisitor;
import org.omg.CORBA.OBJ_ADAPTER;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

public class MovieApplication {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static UserInfo user = new UserInfo();

    public static void main(String[] args) {
        reserveMovie();
        OutputView.printReservedMovieList(user);

        int price = processPayment();
        OutputView.printReserveSuccess(price);
    }

    private static void reserveMovie() {
        do {
            Movie movie = selectMovie(); // 영화 선택
            PlaySchedule playSchedule = selectSchedule(movie); // 시간 선택
            int nPeople = selectPeopleNumber(playSchedule); // 인원 선택

            reserveMovie(movie, playSchedule, nPeople); // 예약

        } while (InputView.selectMoreReserve());
    }

    private static void reserveMovie(Movie movie, PlaySchedule playSchedule, int number) {
        MovieBookingInfo movieBookingInfo = new MovieBookingInfo(movie, playSchedule, number);
        user.addMove(movieBookingInfo);
    }

    private static Movie selectMovie() {
        Movie movie;
        while ((movie = inputMovie()) == null) ;
        return movie;
    }

    private static Movie inputMovie() {
        try {
            OutputView.printMovies(movies);
            int movieId = InputView.inputMovieId();
            return MovieRepository.findById(movieId);

        } catch (IllegalArgumentException e) {
            OutputView.printText(e.getMessage());
            return null;
        }
    }

    private static PlaySchedule selectSchedule(Movie movie) {
        PlaySchedule playSchedule;
        while ((playSchedule = inputPlaySchedule(movie)) == null) ;
        return playSchedule;
    }

    private static PlaySchedule inputPlaySchedule(Movie movie) {

        try {
            OutputView.printPlaySchedule(movie);
            int scheduleIndex = InputView.inputPlaySchedule() - 1;
            return movie.getPlaySchedule(scheduleIndex);

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            OutputView.printText("정확히 입력해 주세요");
            return null;
        }
    }

    private static int selectPeopleNumber(PlaySchedule playSchedule) {
        int nPeople;
        do {
            nPeople = InputView.inputPeopleNumber();
            return nPeople;
        } while (!playSchedule.isFull(nPeople));
    }

    private static int processPayment() {
        int point = InputView.inputPoint(user.getPoint());
        Payment payment = InputView.selectPaymentMethod();
        return payment.getDiscountedPrice(user, point);
    }
}
