import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

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

        } while (InputView.selectMoreReseve());
    }

    private static void reserveMovie(Movie movie, PlaySchedule playSchedule, int number) {
        MovieBookingInfo movieBookingInfo = new MovieBookingInfo(movie, playSchedule, number);
        user.addMove(movieBookingInfo);
    }

    private static Movie selectMovie() {
        // TODO: 예외에 따른 입력 반복 구현
        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();
        return MovieRepository.findById(movieId);
    }

    private static PlaySchedule selectSchedule(Movie movie) {
        // TODO: 예외에 따른 입력 반복 구현
        OutputView.printPlaySchedule(movie);
        int scheduleIndex = InputView.inputPlaySchedule() - 1;
        return movie.getPlaySchedule(scheduleIndex);
    }

    private static int selectPeopleNumber(PlaySchedule playSchedule) {
        int nPeople = InputView.inputPeopleNumber();
        // TODO: 인원 체크
        return nPeople;
    }

    private static int processPayment() {
        int point = InputView.inputPoint(user.getPoint());
        Payment payment = InputView.selectPaymentMethod();
        return payment.getDiscountedPrice(user, point);
    }
}
