import domain.ChoiceMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static List<Movie> movies;
    public static List<ChoiceMovie> choiceMovies = new ArrayList<>();
    public static Movie choiceMovie;
    public static int isContinue=1;

    public static void main(String[] args) {
        movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        while (isContinue!=1){
            int movieId = InputView.inputMovieId();
            for (Movie movie : movies) {
                isContainId(movie, movieId);        //영화 선택
            }
            System.out.println(choiceMovie);        //고른 영화 출력
            ChoiceMovie select=InputView.inputMovieTime(choiceMovies, choiceMovie);  //고른 영화 일단 장바구니

            int member=InputView.inputMember();
            select.setMember(member);
            choiceMovies.add(select);
            isContinue=InputView.inputAddReservation();
        }





    }

    public static void isContainId(Movie movie, int id) {
        if (movie.getId() == id) {
            System.out.println(movie);
            choiceMovie = movie;
        }
    }
}
