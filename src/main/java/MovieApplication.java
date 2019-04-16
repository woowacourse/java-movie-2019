import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static final double SALE_RATE_CARD = 0.95;
    public static final double SALE_RATE_NOCARD = 0.98;

    public static void tryMakingReservation(List<MovieReservation> reservationList) {
        // 영화 보여주기
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        // 예약할 영화를 선택하세요
        int movieId = InputView.inputMovieId();
        Movie selectedMovie = MovieRepository.getMovie(movieId);
        OutputView.printMovie(selectedMovie);

        // 스캐줄 받기
        int scheduleIndex = InputView.inputScheduleIndex(movieId);

        // 예약 인원
        int personCount = InputView.inputReservePersonCount(movieId, scheduleIndex);

        // 무비의 예약시간에 현재정보 적용해주기
        selectedMovie.decreaseScheduleCapacity(scheduleIndex, personCount);
        // 예약리스트에 추가하기
        addToReservationList(reservationList, new MovieReservation(movieId, scheduleIndex, personCount));

        // 예약 종료할지 더할지
        if (InputView.inputWannaEndMovieChoice()) {
            return;
        }
        tryMakingReservation(reservationList);
    }

    public static void addToReservationList(List<MovieReservation> reservationList, MovieReservation movieReservation) {
        boolean isSameMovieExist = reservationList.stream().anyMatch(reserve -> reserve.isSameReservation(movieReservation));
        if (isSameMovieExist) {
            for (int i = 0; i < reservationList.size(); i++) {
                if (reservationList.get(i).isSameReservation(movieReservation)) {
                    reservationList.get(i).increaseCount(movieReservation.getPersonCount());
                    return;
                }
            }
        }
        reservationList.add(movieReservation);
    }

    public static void showAllReservation(List<MovieReservation> reservationList) {
        // 지금까지 예약내역 보여주기
        for (int i = 0; i < reservationList.size(); i++) {
            MovieReservation reserveInfo = reservationList.get(i);
            Movie movie = MovieRepository.getMovie(reserveInfo.getMovieId());
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
            Movie movie = MovieRepository.getMovie(reserveInfo.getMovieId());
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
        System.out.println(String.format("## 최종 결제한 금액은 %d 원 입니다.",payMoney));


    }

    public static void main(String[] args) {
        List<MovieReservation> reservationList = new ArrayList<MovieReservation>();

        // 예약 하기
        tryMakingReservation(reservationList);
        // 선택된 모든 예약 보여주기
        showAllReservation(reservationList);
        // 모든 금액 계산하기
        int totalMoney = getTotalPayment(reservationList);
        // 포인트 금액 계산하기
        int pointUseAmount = InputView.inputPoint();
        // 신용카드 인지 현금인지
        boolean isCardUse = InputView.inputIsCardUse();
        // 계산하기
        pay(totalMoney - pointUseAmount, isCardUse);
        System.out.println("## 예매를 완료했습니다. 즐거운 영화 관람되세요.");

    }
}
