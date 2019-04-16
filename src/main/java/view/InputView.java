package view;


import domain.Movie;
import domain.ReserveTime;
import domain.ReservedMovie;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            int reserveMovie = scanner.nextInt();
            ReservedMovie reservedMovie = new ReservedMovie(reserveMovie);
            return reservedMovie.getReservedMovie();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputMovieId();
        }
    }

    public static int inputReserveTime(Movie movie){
        try {
            System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
            int reserveTime  = scanner.nextInt();
            ReserveTime reserveTime1 = new ReserveTime(movie,reserveTime);
            return reserveTime;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return inputReserveTime(movie);
        }
    }

    public static List<Integer> ConvertStringToInt(List<String> movies) {
        List<Integer> reservateMovies = movies.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return reservateMovies;
    }
}
