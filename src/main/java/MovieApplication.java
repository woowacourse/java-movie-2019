import domain.Movie;
import domain.MovieRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static domain.MovieRepository.getMovies;
import static view.InputView.inputMovieId;

public class MovieApplication {

    private final int FIRST_MOVIE = 1;
    private final int SECOND_MOVIE = 5;
    private final int THIRD_MOVIE = 7;
    private final int FOURTH_MOVIE = 8;
    private final int SET_MOVIE_NUMVER = 4;


    private void printMovieList(int movieId){

        if(movieId == FIRST_MOVIE){

            System.out.println(getMovies().get(movieId - FIRST_MOVIE));
        }
        if(movieId == SECOND_MOVIE || movieId == THIRD_MOVIE ||
                movieId == FOURTH_MOVIE ){

            System.out.println(getMovies().get(movieId - SET_MOVIE_NUMVER));
        }
        if(movieId != FIRST_MOVIE && movieId != SECOND_MOVIE &&
                movieId != THIRD_MOVIE &&
                movieId != FOURTH_MOVIE ){

            throw new IllegalArgumentException();
        }

    }
    public static void main(String[] args) {
        List<Movie> movies = getMovies();
        OutputView.printMovies(movies);
        MovieApplication movieCompany = new MovieApplication();

        movieCompany.checkMovieId();

        // TODO 구현 진행
    }

    private void checkMovieId(){
        
        while(true){
            try{
                int movieIdValue = inputMovieId();
                printMovieList(movieIdValue);
                break;
            } catch(Exception e){

                System.out.println("잘못된 값을 입력하셨습니다 다시 입력해주십시오");
            }
        }
    }

}
