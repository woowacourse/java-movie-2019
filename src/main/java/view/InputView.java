package view;

import domain.Movie;
import exception.InputMovException;
import utils.DateTimeUtils;

import java.util.ArrayList;
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
        if(!checkMovieSch(inputSch,movie)){
            throw new InputMovException("시간표의 숫자만 입력해주세요.");
        }
        if(!DateTimeUtils.isPastMovieSch(movie.getSchStartTime(inputSch-1))){
            throw new InputMovException("지난 시간의 영화는 예매할 수 없습니다.");
        }

        return inputSch;
    }

    /**
     * 1. 영화 스케줄 길이
     * 2. 지금 시간보다 늦은
     * 3. 이전 영화보다 한시간 이내의(추후 추가 필요)
     * */
    private static boolean checkMovieSch(int inputSch, Movie movie){
        if(inputSch < 1 || inputSch > movie.getSchSize() ){
            return false;
        }
        return true;
    }

    private static int checkInputMovieId(List<Movie> movies) throws NumberFormatException, InputMovException {
        System.out.println("## 예약할 영화를 선택하세요.");
        int inputId = Integer.parseInt(scanner.nextLine());
        if(!checkMovieId(inputId, movies)){
            throw new InputMovException();
        }
        return inputId;
    }

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
