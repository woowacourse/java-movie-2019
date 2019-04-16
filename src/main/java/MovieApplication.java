import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

import static domain.MovieRepository.getMovies;
import static view.InputView.inputMovieId;

public class MovieApplication {

    private final int FIRST_MOVIE = 1;
    private final int ANOTHER_MOVIE = 4;
    private int getMovieValue(){

        Scanner scanMovieValue = new Scanner(System.in);
        int movieId = scanMovieValue.nextInt();
        return movieId;
    }

    private void printMovieList(int movieId){

        if(movieId == 1){
            System.out.println(getMovies().get(movieId - FIRST_MOVIE));
        }
        if(movieId != 1){
            System.out.println(getMovies().get(movieId - ANOTHER_MOVIE));
        }
    }
    public static void main(String[] args) {
        List<Movie> movies = getMovies();
        OutputView.printMovies(movies);
        MovieApplication movieCompany = new MovieApplication();

        movieCompany.printMovieList(movieCompany.getMovieValue());

        // TODO 구현 진행
    }

    private int checkMovieId(){

        Scanner scanMovieName = new Scanner(System.in);
        int movieIdValue;

        while(true){
            try{
                inputMovieId();
                String movieIdString = scanMovieName.nextLine();
                movieIdValue = Integer.parseInt(movieIdString);
                break;
            } catch(Exception e){

                System.out.println("잘못된 값을 입력하셨습니다 다시 입력해주십시오");
            }
        }
        return movieIdValue;
    }
}
