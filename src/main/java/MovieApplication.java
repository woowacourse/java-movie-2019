import com.sun.corba.se.impl.orbutil.ObjectUtility;
import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    static final int CARD = 1;
    static final int CASH = 2;

    static List<Reservation> reservations = new ArrayList<Reservation>();
    static List<Movie> movies = MovieRepository.getMovies();


    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while(flag){
            flag = reservationOneCycle();
        }
        OutputView.printReservation(reservations);
        payment();
        // TODO 구현 진행
    }

    private static boolean reservationOneCycle() throws IOException{
        try {
            OutputView.printMovies(movies);
            Movie chooseMovie = movieChoose();
            OutputView.printMovie(chooseMovie);
            int scheduleNumber = InputView.inputScheduleNumber();
            int reservationPersonnel = InputView.inputReservationPersonnel();
            Reservation reservation = new Reservation(chooseMovie, reservationPersonnel, scheduleNumber);
            validReservation(reservation);
            reservations.add(reservation);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return InputView.goPaymentOrAddReservation();
    }

    private static void validReservation(Reservation Validreservation)throws IllegalArgumentException{
        for(Reservation reservation : reservations){
            if(!DateTimeUtils.isOneHourWithinRange(reservation.getPlaySchedule().getStartDateTime(),
                    Validreservation.getPlaySchedule().getStartDateTime())){
                throw new IllegalArgumentException("시간대가 맞지 않습니다.");
            }
        }
    }


    private static Movie movieChoose() throws IOException{
        int movieId;
        movieId= InputView.inputMovieId();
        return MovieRepository.getMovie(movieId);
    }

    private static void payment() throws IOException{
        long beforeTotalMoney = beforeTotal();
        long point = InputView.inputPoint(beforeTotalMoney);
        beforeTotalMoney = beforeTotalMoney - point;
        int payment = InputView.inputCashOrCard();
        long totalMoney = calculateTotalMoney(beforeTotalMoney, payment);
        OutputView.printTotalPayment(totalMoney);
    }

    private static long beforeTotal(){
        long beforeTotalMoney = 0;
        for(Reservation reservation : reservations){
            beforeTotalMoney += reservation.getTotalMoney();
        }
        return beforeTotalMoney;
    }

    private static long calculateTotalMoney(long beforeTotalMoney, int payment){
        if(payment == CARD){
            return (Math.round(beforeTotalMoney * 0.95));
        }
        return (Math.round(beforeTotalMoney * 0.98));
    }

}
