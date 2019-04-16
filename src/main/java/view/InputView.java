package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_ID_MSG = "## 예약할 영화를 선택하세요.";

    private static final String ERROR_MSG_INPUT_MOVIE_ID = "숫자만 입력해주세요.";
    private static final String ERROR_MSG_OUT_OF_VALUE_MOVIE_ID = "해당 영화는 없는 영화 입니다.";

    public static int inputMovieId() {
        int movieId;
        try{
            System.out.println(INPUT_MOVIE_ID_MSG);
            movieId = scanner.nextInt();
            if(!checkingOutOfValueMovieId(movieId)){
               throw new NullPointerException();
            }
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_MOVIE_ID);
            scanner.next();
            return  inputMovieId();
        }catch (NullPointerException e){
            System.out.println(ERROR_MSG_OUT_OF_VALUE_MOVIE_ID);
            return inputMovieId();
        }
        return movieId;
    }

    private static boolean checkingOutOfValueMovieId(int movieId){
        List<Movie> movieList = MovieRepository.getMovies();
        for(Movie movie : movieList){
            if(movie.isMatchedMovieId(movieId)){
                return true;
            }
        }
        return false;
    }


}
