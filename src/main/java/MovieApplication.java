import domain.Movie;
import domain.MovieRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.*;

import static domain.MovieRepository.getMovies;
import static view.InputView.inputMovieId;

public class MovieApplication {

    private final int FIRST_MOVIE = 1;
    private final int SECOND_MOVIE = 5;
    private final int THIRD_MOVIE = 7;
    private final int FOURTH_MOVIE = 8;
    private final int SET_MOVIE_NUMVER = 4;

    private List<Integer> getInMovieIdList(String[] movieIdString){

        List<Integer> movieIdList = new ArrayList<Integer>();
        for(int i=0;i<movieIdString.length;i++){

            movieIdList.add(Integer.parseInt(movieIdString[i]));
        }
        return movieIdList;
    }

    private void printMovieList(String movieIdString){

        String[] movieIdStringArrays = movieIdString.split("");
        List<Integer> movieIdArrayList = new ArrayList<Integer>();
        movieIdArrayList = getInMovieIdList(movieIdStringArrays);

        for(int i=0; i<movieIdArrayList.size();i++) {

            getFirstMovie(movieIdArrayList, i);
            getSecondToFourthMovie(movieIdArrayList, i);
            getException(movieIdArrayList, i);
        }
    }

    private void getException(List<Integer> movieIdArrayList, int i) {
        if (movieIdArrayList.get(i) != FIRST_MOVIE && movieIdArrayList.get(i) != SECOND_MOVIE &&
                movieIdArrayList.get(i) != THIRD_MOVIE &&
                movieIdArrayList.get(i) != FOURTH_MOVIE) {

            System.out.println("문자열 혹은 맞는 영화 번호를 입력하셨는지 확인하세요");
            throw new IllegalArgumentException();
        }
    }

    private void getSecondToFourthMovie(List<Integer> movieIdArrayList, int i) {
        if (movieIdArrayList.get(i) == SECOND_MOVIE || movieIdArrayList.get(i) == THIRD_MOVIE ||
                movieIdArrayList.get(i) == FOURTH_MOVIE) {

            System.out.println(getMovies().get(movieIdArrayList.get(i) - SET_MOVIE_NUMVER));
        }
    }

    private void getFirstMovie(List<Integer> movieIdArrayList, int i) {
        if (movieIdArrayList.get(i) == FIRST_MOVIE) {

            System.out.println(getMovies().get(movieIdArrayList.get(i) - FIRST_MOVIE));
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
                String movieIdValue = inputMovieId();
                printMovieList(movieIdValue);
                break;
            } catch(Exception e){

                System.out.println("다시 입력해주십시오.");
            }
        }
    }

    

}
