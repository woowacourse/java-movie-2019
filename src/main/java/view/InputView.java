package view;

import domain.Movie;
import exception.InputMovIdException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId(List<Movie> movies) {
        try{
            return chekcInputMovieId(scanner, movies);
        } catch (NumberFormatException e){
            System.out.println("숫자만 입력해주세요");
            return inputMovieId(movies);
        } catch (InputMovIdException e){
            System.out.println("상영 목록의 번호를 입력해주세요");
            return inputMovieId(movies);
        }
    }

    private static int chekcInputMovieId(Scanner scanner, List<Movie> movies) throws NumberFormatException, InputMovIdException {
        System.out.println("## 예약할 영화를 선택하세요.");
        int inputId = Integer.parseInt(scanner.nextLine());
        if(!checkMovieId(inputId, movies)){
            throw new InputMovIdException();
        }
        return inputId;
    }

    /**
     * 영화 리스트안에 들어있는 숫자만 리턴
     * */
    private static boolean checkMovieId(int inputId, List<Movie> movies){
        List<Integer> moviesIdList = new ArrayList<>();
        for(Movie movie : movies){
            moviesIdList.add(movie.getId());
        }
        if(moviesIdList.contains(inputId)){
            return true;
        }
        return false;
    }
}
