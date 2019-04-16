import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import domain.PlaySchedule;
import utils.MovieDataRequester;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static final double SALE_RATE_CARD = 0.95;
    public static final double SALE_RATE_NOCARD = 0.98;

    public static void makeReservation(List<MovieReservation> reservationList) {
        OutputView.printMovies(MovieRepository.getMovies());

        int movieId = InputView.inputMovieId();
        Movie selectedMovie = MovieDataRequester.getMovie(movieId);
        OutputView.printMovie(selectedMovie);
        int scheduleIndex = InputView.inputScheduleIndex(movieId);
        int personCount = InputView.inputReservePersonCount(movieId, scheduleIndex);
        selectedMovie.decreaseScheduleCapacity(scheduleIndex, personCount);
        addToReservationList(reservationList, new MovieReservation(movieId, scheduleIndex, personCount));
        if (InputView.inputWannaEndMovieChoice()) {
            return;
        }
        makeReservation(reservationList);
    }

    public static void addToReservationList(List<MovieReservation> reservationList, MovieReservation movieReservation) {
        boolean isSameMovieExist = reservationList.stream().anyMatch(reserve -> reserve.isSameReservation(movieReservation));

        if (isSameMovieExist) {
            reservationList.stream()
                    .filter(reserve->reserve.isSameReservation(movieReservation))
                    .forEach(reserve->reserve.increaseCount(movieReservation.getPersonCount()));
            return;
        }
        reservationList.add(movieReservation);
    }

    public static void showAllReservation(List<MovieReservation> reservationList) {
        for (int i = 0; i < reservationList.size(); i++) {
            MovieReservation reserveInfo = reservationList.get(i);
            Movie movie = MovieDataRequester.getMovie(reserveInfo.getMovieId());
            PlaySchedule playSchedule = movie.getSchedule(reserveInfo.getScheduleIndex());
            int printPersonCount = reserveInfo.getPersonCount();

            System.out.println("예약 내역");
            movie.showBasicInfo();
            playSchedule.showOnlyTimeInfo();
            System.out.println("예약인원:" + printPersonCount + "명");
        }
    }

    public static int getTotalPayment(List<MovieReservation> reservationList) {
        System.out.println("## 결제를 진행합니다.");
        int totalMoney = 0;
        for (int i = 0; i < reservationList.size(); i++) {
            MovieReservation reserveInfo = reservationList.get(i);
            Movie movie = MovieDataRequester.getMovie(reserveInfo.getMovieId());
            int printPersonCount = reserveInfo.getPersonCount();

            totalMoney += movie.calculateTotalReserveMoney(printPersonCount);
        }
        return totalMoney;
    }

    public static double getSalePercent(boolean isCard) {
        if (isCard) {
            return SALE_RATE_CARD;
        }
        return SALE_RATE_NOCARD;
    }

    public static void pay(int payExceptPoint, boolean isCard) {
        if (payExceptPoint <= 0) {
            System.out.println(String.format("## 최종 결제한 금액은 0 원 입니다."));
            return;
        }
        int payMoney = (int) (payExceptPoint * (getSalePercent(isCard)));
        System.out.println(String.format("## 최종 결제한 금액은 %d 원 입니다.", payMoney));


    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<MovieReservation> reservationList = new ArrayList<MovieReservation>();

        makeReservation(reservationList);
        showAllReservation(reservationList);
        int totalMoney = getTotalPayment(reservationList);
        int pointUseAmount = InputView.inputPoint();
        boolean isCardUse = InputView.inputIsCardUse();
        pay(totalMoney - pointUseAmount, isCardUse);
        System.out.println("## 예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
