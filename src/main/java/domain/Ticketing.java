package domain;

import view.InputView;
import view.OutputView;
import java.util.List;

/**
 * 영화 예매 전체를 위한 클래스
 * 영화 예매 과정, 결제 과정 메소드 구현
 * 사용자 입력에 대한 처리
 */

public class Ticketing {
    public static ReserveMovie startTitcketing() {
        int movieId = InputView.inputMovieId();
        Movie currentMovie = MovieRepository.searchMovies(movieId, 0);
        OutputView.printMovie(currentMovie);
        int movieTimeTable = InputView.inputTimetable(currentMovie);
        int movieNumOfPerson = InputView.inputNumOfPerson(currentMovie, movieTimeTable);
        return new ReserveMovie(currentMovie, currentMovie.getPlaySchedules().get(movieTimeTable), movieNumOfPerson);
    }

    public static void startPayment(List<ReserveMovie> reserveMovieList) {
        int point = InputView.inputPayment();
        int totalPrice = 0;
        int credit = InputView.inputCreditCard(reserveMovieList);

        for (ReserveMovie reserveMovie : reserveMovieList) {
            totalPrice += reserveMovie.getMovie().getPrice() * reserveMovie.getNumOfPerson();
        }
        totalPrice -= point;
        totalPrice *= (credit == 1) ? 0.95 : 0.98;
        OutputView.printPayment(totalPrice);
    }
}
