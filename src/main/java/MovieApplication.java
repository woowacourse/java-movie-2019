import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class MovieApplication {
    private static List<Movie> reserveMovies;
    private static int movieCount = 0;

    private static Boolean inputReserveMovie(List<Movie> movies){
        int movieId = InputView.inputMovieId();
        InputView.fflush();
        if(checkMovieList(movieId, movies) == null) {
            System.out.println("상영목록에 없는 영화입니다. 다시 선택해주세요.");
            return false;
        }
        reserveMovies.add(checkMovieList(movieId, movies));
        return true;
    }

    private static Movie checkMovieList(int movieId, List<Movie> movies){
        for(Movie movie : movies){
            if(movie.getMovieId() == movieId){
                return movie;
            }
        }
        return null;
    }

    private static Boolean inputMovieTime(){
        int reserveTime = InputView.inputTime();
        InputView.fflush();
        if(checkMovieTime(reserveTime) == false){
            System.out.println("상영 시작 시간이 이미 지난 영화입니다. 다시 선택해주세요.");
            return false;
        }
        reserveMovies.get(movieCount).decideMovieTime(reserveTime);
        return true;
    }

    private static Boolean checkMovieTime(int TimeNum){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime movieTime = reserveMovies.get(movieCount).getMovieTime(TimeNum - 1);

        return currentTime.isBefore(movieTime);
    }

    private static int inputreserveNum(){
        int reserveNum = InputView.inputNum();
        InputView.fflush();

        if(checkMoviePerson(reserveNum) == false){
            System.out.println("예매 가능 인원을 초과하였습니다. 다시 선택해주세요.");
            return -1;
        }
        return reserveNum;
    }

    private static Boolean checkMoviePerson(int reserveNum){
        if(reserveNum > reserveMovies.get(movieCount).getScheduleCapacity()){
            return false;
        }
        return true;
    }

    private static int inputDecisionNum(){
        int DecisionNum = InputView.inputDecisionNum();
        InputView.fflush();
        return DecisionNum;
    }

    private static void printReserveInfo(int reservePersonNum){
        System.out.println("예약내역");
        OutputView.printMovies(reserveMovies);
        System.out.println("예약 인원: " + reservePersonNum + "명");
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        reserveMovies = new ArrayList<>();
        int reservePerson = -1;

        while(inputReserveMovie(movies) == false){ };
        OutputView.printMovies(reserveMovies);
        while(inputMovieTime() == false) { }
        while(reservePerson == -1) {
            reservePerson = inputreserveNum();
        }

        if(inputDecisionNum() == 1){
            printReserveInfo(reservePerson);
        }

    }

}
