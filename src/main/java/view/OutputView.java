package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printAMovie(Movie aMovie) {
        System.out.println(aMovie);
    }

    public static void printReserveList(Movie aMovie, int movieTime, int reserveCount) {
        System.out.println("예매 내역");
        System.out.println(aMovie.toStringFromIdAndTime(movieTime, reserveCount));
    }

    public static void printProcessMessage() {
        System.out.println("## 결제를 진행합니다.");
    }
}
