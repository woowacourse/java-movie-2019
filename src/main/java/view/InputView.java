package view;


import domain.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Movie> inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            List<String> movies = Arrays.asList(scanner.nextLine().split(","));
            List<Integer> reservateMovies = ConvertStringToInt(movies);
            ReservatingMovie reservatingMovie = new ReservatingMovie(reservateMovies);
            List<Movie> reservatedMovies = reservatingMovie.GenerateReservatedMovie();
            return reservatedMovies;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputMovieId();
        }
    }

    public static List<Integer> ConvertStringToInt(List<String> movies) {
        List<Integer> reservateMovies = movies.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return reservateMovies;
    }
}
