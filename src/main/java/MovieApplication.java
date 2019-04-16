import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.ReservationList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
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

        reservationList.showResrvationList();

        // 결제
        int amountOfPointToUse = InputView.inputAmountOfPointToUse();
        int paymentMethod = InputView.inputPaymentMethod();



    }
}
