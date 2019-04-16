package view;

import domain.Money;
import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie){
        System.out.println(movie);
    }

    public static void printSchedule(Movie chooseMovie, int scheduleNumber){
        chooseMovie.printSchedule(scheduleNumber);
    }

    public static void printReservation(List<Reservation> reservationList){
        System.out.println("예약 내역");
        for(Reservation reservation : reservationList){
            System.out.println(reservation);
        }
    }

    public static void printTotalPayment(Money money){
        System.out.println(money.printTotalMoney()+ "\n"+
                "예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
