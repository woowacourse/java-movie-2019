import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    public static final String RESERVATION_END_MESSAGE = "예매를 완료했습니다. 즐거운 영화관람 되세요";

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        ReservationList reservationList = new ReservationList();

        int endOrAddReservation = 2;

        // 예약
        while(endOrAddReservation == 2){
            int movieId = InputView.inputMovieId();
            int moviePlaySchedule = InputView.inputMoviePlaySchedule(MovieRepository.getMovie(movieId));
            int peopleNumberOfResrvation = InputView.inputPeopleNumberOfReservation(
                    MovieRepository.getMovie(movieId).getPlaySchedule(moviePlaySchedule));

            reservationList.addReservation(new Reservation(movieId, moviePlaySchedule, peopleNumberOfResrvation));

            endOrAddReservation = InputView.inputEndOrAddReservation();
        }

        // 예약 내역 보여주기
        reservationList.showResrvationList();

        // 결제
        long totalAmountOfPayment = reservationList.getTotalAmountOfPayment();
        int amountOfPointToUse = InputView.inputAmountOfPointToUse();
        int paymentMethod = InputView.inputPaymentMethod();

        Payment payment = new Payment(paymentMethod, amountOfPointToUse, totalAmountOfPayment);
        System.out.println(payment);
        System.out.println(RESERVATION_END_MESSAGE);

    }
}
