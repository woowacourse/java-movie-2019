package view;

import domain.ChoiceMovie;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            return isContainMovieId(intException());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int intException(){
        return scanner.nextInt();
    }

    public static int isContainMovieId(int inputId){
        List<Movie> movies = MovieRepository.getMovies();
        List<Integer> ids = new ArrayList<>();
        for(Movie movie:movies){
            ids.add(movie.getId());
        }
        if(ids.contains(inputId)){
            return inputId;
        }
        throw new IllegalArgumentException("상영하고 있는 영화의 id를 입력해주세요. ");
    }

    public static int inputMovieTime(Movie choiceMovie){
        try {
            System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영시간이 1번)");
            return isContainTime(choiceMovie,intException());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMovieTime(choiceMovie);
        }
    }
    public static int isContainTime(Movie movie,int inputTime){
        if(movie.getPlaySchedulesLength()<inputTime || inputTime<0){
            throw new IllegalArgumentException("올바른 상영시간표를 선택해 주세요.");
        }
        return inputTime;
    }

    public static LocalDateTime isOverOneHour(List<ChoiceMovie> choiceMovies, ChoiceMovie movie){
        LocalDateTime movieTime = movie.getPlaySchedules().getStartDateTime();
        for(ChoiceMovie choice :choiceMovies){
            if(!DateTimeUtils.isOneHourWithinRange(choice.getPlaySchedules().getStartDateTime(),movieTime)){
                throw new IllegalArgumentException("한가지 이상의 영화를 예매했을 경우 예매하려는 영화의 시작시간과 차이가 1시간 이상 차이날 수 없습니다.");
            }
        }
        return movieTime;
    }
    public static int inputMember(){
        try {
            System.out.println("## 예약할 인원을 입력하세요.");
            return intException();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMember();
        }
    }
    public static int inputAddReservation(){
        try {
            System.out.println("## 예약을 종료하고 결제를 진행하려면 1번,추가 예약을 진행하려면 2번");
            return isOneOrTwo(intException());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAddReservation();
        }
    }
   public static int isOneOrTwo(int input){
        if(!(input==1 || input==2)){
            throw new IllegalArgumentException("입력은 1또는 2를 입력해 주세요.");
        }
        return input;
   }

}
