package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
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
}
