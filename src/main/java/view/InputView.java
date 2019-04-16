package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservationMachine;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NOT_INTEGER_ERROR_MESSAGE = "정수를 입력해 주세요.";
    private static final String NOT_AVAILABLE_MOVIE_ID_ERROR_MESSAGE = "현재 상영중인 영화의 번호들 중에서 선택하세요.";


    /**
     * 현재 상영중인 영화의 번호들 중 하나를 입력받는 메소드. 성공할 때까지 반복함.
     */
    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId;
        try {
            return getValidMovieId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    /**
     * 영화 번호를 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getValidMovieId() {
        int id = getInteger();
        if (isValidId(id, MovieRepository.getMovies())) {
            return id;
        } else {
            throw new InputMismatchException(NOT_AVAILABLE_MOVIE_ID_ERROR_MESSAGE);
        }
    }

    /**
     * 정수 하나를 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new InputMismatchException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    /**
     * 영화의 번호가 영화들의 번호 중에 존재하는 지 확인하는 메소드
     */
    private static boolean isValidId(int id, List<Movie> movies) {
        Iterator<Movie> it = movies.iterator();
        boolean isValid = false;
        while (it.hasNext()) {
            Movie thisMovie = it.next();
            isValid = (thisMovie.isId(id)) ? true : isValid;
        }
        return isValid;
    }
}
