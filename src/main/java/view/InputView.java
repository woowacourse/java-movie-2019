package view;

import domain.MovieRepository;
import utils.CheckValidity;

import java.util.Scanner;

public class InputView extends CheckValidity {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputMovieId() {
        String movieId;
        do {
            System.out.println("## 예약할 영화를 선택하세요.");
            movieId = scanner.next();
        } while (!validityMovieId(movieId));
        return Integer.parseInt(movieId);
    }

    private boolean validityMovieId(String movieId) {
        return checkValidityIntegerFormat(movieId)
                && checkIsContainOfMovies(MovieRepository.getMovieIds(), Integer.parseInt(movieId));
    }
}
