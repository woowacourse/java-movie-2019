package view;

import domain.Movie;
import domain.MovieRepository;

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

}
