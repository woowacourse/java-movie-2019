package view;

import domain.Booker;
import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(int movieId) {
        System.out.println(MovieRepository.getMovie(movieId));
    }

    public static void printResultBooking(Booker booker){
        System.out.println("예약 내역");
        for(String result : booker.printResult()){
            System.out.println(result);
            System.out.println();
        }
    }
}
