package view;

import domain.Movie;
import exception.InputMovException;
import utils.InputCheckFunc;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId(List<Movie> movies) {
        try{
            return checkInputMovieId(movies);
        } catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요");
            return inputMovieId(movies);
        } catch (InputMovException e){
            System.out.println("상영 목록의 번호를 입력해주세요");
            return inputMovieId(movies);
        }
    }

    private static int checkInputMovieId(List<Movie> movies) throws NumberFormatException, InputMovException {
        System.out.println("## 예약할 영화를 선택하세요.");
        int inputId = Integer.parseInt(scanner.nextLine());
        InputCheckFunc.checkMovieId(inputId, movies);
        return inputId;
    }

    public static int inputMovieSch(Movie movie, List<Movie> movReservation){
        try{
            return checkInputMovieSch(movie, movReservation);
        } catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요");
            return inputMovieSch(movie, movReservation);
        } catch (InputMovException e){
            System.out.println(e.EXCEPTION_STR);
            return inputMovieSch(movie, movReservation);
        }
    }

    private static int checkInputMovieSch(Movie movie, List<Movie> movReservation){
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        int inputSch = Integer.parseInt(scanner.nextLine());
        InputCheckFunc.checkMovieSch(inputSch,movie);

        return inputSch;
    }

}
