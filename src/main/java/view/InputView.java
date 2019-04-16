package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_ID_MSG = "## 예약할 영화를 선택하세요.";
    private static final String INPUT_MOVIE_PLAY_SCHEDULE_MSG = "## 예약할시간표를선택하세요.(첫번째상영시간이1번)";
    private static final String INPUT_MOVIE_RESERVATION_NUM_MSG = "## 예약할인원을입력하세요.";
    private static final String INPUT_PAYMENT_OR_ADD_RESERVATION_MSG = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";

    private static final String ERROR_MSG_INPUT_NOT_NUMBER = "숫자만 입력해주세요.";
    private static final String ERROR_MSG_OUT_OF_VALUE_MOVIE_ID = "해당 영화는 없는 영화 입니다.";
    private static final String ERROR_MSG_OUT_OF_VALUE_MOVIE_PLAY_SCHEDULE = "해당 상영시간은 없습니다.";
    private static final String ERROR_MSG_OUT_OF_VALUE_RESERVATION_NUM = "인원이 초과하여 예약할 수 없습니다.";
    private static final String ERROR_MSG_OUT_OF_VALUE_ANSWER = "대답은 1또는 2로 해주세요.";

    public static int inputMovieId(List<Movie> movies) {
        int movieId;
        try{
            System.out.println(INPUT_MOVIE_ID_MSG);
            movieId = scanner.nextInt();
            isExistMovieId(movies, movieId);
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_NOT_NUMBER);
            scanner.next();
            return  inputMovieId(movies);
        }catch (NullPointerException e){
            System.out.println(ERROR_MSG_OUT_OF_VALUE_MOVIE_ID);
            return inputMovieId(movies);
        }
        return movieId;
    }

    private static void isExistMovieId(List<Movie> movies, int movieId){
        for(Movie movie : movies){
            if(movie.isMatchedMovieId(movieId)) {
                return;
            }
        }
        throw new NullPointerException();
    }

    public static int inputMoviePlaySchedule(Movie movie){
        int playSchedule;
        try{
            System.out.println(INPUT_MOVIE_PLAY_SCHEDULE_MSG);
            playSchedule = scanner.nextInt();
            isExistMovieSchedule(movie, playSchedule);
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_NOT_NUMBER);
            scanner.next();
            return  inputMoviePlaySchedule(movie);
        }catch (NullPointerException e){
            System.out.println(ERROR_MSG_OUT_OF_VALUE_MOVIE_PLAY_SCHEDULE);
            return inputMoviePlaySchedule(movie);
        }
        return playSchedule;
    }

    private static void isExistMovieSchedule(Movie movie, int timeNum){
        if(movie.isOverPlaySchedule(timeNum)){
            throw new NullPointerException();
        }
    }

    public static int inputReservationNumber(Movie movie, int timeNum){
        int reservationNum;
        try{
            System.out.println(INPUT_MOVIE_RESERVATION_NUM_MSG);
            reservationNum = scanner.nextInt();
            isPossibleReserve(movie, timeNum, reservationNum);
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_NOT_NUMBER);
            scanner.next();
            return  inputReservationNumber(movie, timeNum);
        }catch (NullPointerException e){
            System.out.println(ERROR_MSG_OUT_OF_VALUE_RESERVATION_NUM);
            return inputReservationNumber(movie, timeNum);
        }
        return reservationNum;
    }

    private static void isPossibleReserve(Movie movie, int timeNum, int reservationNum){
        if(!movie.isPossibleTime(timeNum, reservationNum)){
            throw new NullPointerException();
        }
    }

    public static int inputPlayPaymentOrAdditionalOrder(){
        int answer;
        try{
            System.out.println(INPUT_PAYMENT_OR_ADD_RESERVATION_MSG);
            answer = scanner.nextInt();
            isPossibleAnswer(answer);
        }catch (InputMismatchException e){
            System.out.println(ERROR_MSG_INPUT_NOT_NUMBER);
            scanner.next();
            return inputPlayPaymentOrAdditionalOrder();
        }catch (NullPointerException e){
            System.out.println(ERROR_MSG_OUT_OF_VALUE_ANSWER);
            return inputPlayPaymentOrAdditionalOrder();
        }
        return answer;
    }

    private static void isPossibleAnswer(int answer){
        if(answer <= 0 || answer > 2){
            throw new NullPointerException();
        }
    }
}
