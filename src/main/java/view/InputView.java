package view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputMovieId() {
        try{
            System.out.println("## 예약할 영화를 선택하세요.");
            List<String> movies = Arrays.asList(scanner.nextLine().split(","));
            List<Integer> reservateMovies = movies.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            ReservatingMovie reservatingMovie = new ReservatingMovie(reservateMovies);
            return reservateMovies;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return inputMovieId();
        }

    }
}
