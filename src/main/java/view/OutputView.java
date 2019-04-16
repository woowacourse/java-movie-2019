package view;

import domain.Movie;
import domain.Payment;
import domain.PlaySchedule;
import domain.ReserveMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printSelectedMovie(Movie movie) {
        try {
            System.out.println(movie.toString());
        } catch (NullPointerException e) {

        }
    }

    public static boolean printPayOrReserve(int order, ReserveMovie reserveMovie){
        if (order == 1){
            System.out.println(reserveMovie.toString());
            return false;
        }
        return true;
    }

    public static void printFinishReserveI(Payment payment){
        System.out.println(payment.toString());
    }




}
