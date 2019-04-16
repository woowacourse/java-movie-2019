import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.ReserveMovie;
import utils.DateTimeUtils;
import utils.Validator;
import view.InputView;
import view.OutputView;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie selectedMovie;
        boolean validateCheck;
        boolean reserveAdd;

        int movieId = InputView.inputMovieId();
        while (true){
            selectedMovie = MovieRepository.getSelectedMovie(movieId);
            OutputView.printSelectedMovie(selectedMovie);
            validateCheck = Validator.nullChecker(selectedMovie);
            if(validateCheck) break;
            System.out.println("현재 상영하지 않는 영화를 선택했습니다. 다시 선택해주세요!");
        }

        int movieSchedule;
        while (true) {
            movieSchedule = InputView.inputMovieSchedule();
            System.out.println();
            validateCheck = Validator.scheduleSizeChecker(selectedMovie, movieSchedule);
            if (validateCheck) break;
            System.out.println("시간표를 다시한번 확인해주세요!");
        }

        int moviePersonCount;
        while (true) {
            moviePersonCount = InputView.inputPersonCount();
            System.out.println();
            validateCheck = Validator.movieAvailableSeat(selectedMovie, moviePersonCount, movieSchedule);
            if (validateCheck) break;
            System.out.println("죄송합니다 좌석이 부족합니다!");
        }

        ReserveMovie reserveMovie = new ReserveMovie(selectedMovie, moviePersonCount, movieSchedule);

        int inputPayment;
        while (true) {
            inputPayment = InputView.inputPayment();
            System.out.println();
            validateCheck = Validator.lastInputChecker(inputPayment);
            reserveAdd = OutputView.printPayOrReserve(inputPayment, reserveMovie);
            if (validateCheck) break;
            System.out.println("1 또는 2만 입력해주세요!");
        }

        int inputPoint = InputView.startPayment();
        System.out.println();

        int paymentType;
        while (true) {
            paymentType = InputView.inputPaymentType();
            System.out.println();
            validateCheck = Validator.lastInputChecker(paymentType);
            if (validateCheck) break;
            System.out.println("1 또는 2만 입력해주세요!");
        }

        Payment payment = new Payment(reserveMovie, paymentType, inputPoint);
        OutputView.printFinishReserveI(payment);
        // TODO 구현 진행
    }
}
