import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule; ////////////////////추가 가능?
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    private static List<Movie> curMovies = new ArrayList<>();
    private static List<PlaySchedule> curSchedule = new ArrayList<>();
    private static List<Integer> ppl = new ArrayList<>();

    private static void printSelectMovie(int movieId,int no) {
        Movie temp = MovieRepository.getSelectMovies(movieId);
        if (temp == null) {
            System.out.println("해당 영화가 없습니다.");
        } else {
            System.out.println(temp);
            curMovies.add(temp);
        }
    }

    private static void selecMovieTime(int no){
        int selectTime = InputView.inputTime();
        PlaySchedule tempSchedule = curMovies.get(no).getSchedule(selectTime);
        System.out.println(tempSchedule);
        curSchedule.add(tempSchedule);
    }

    private static void getPpl(int no){
        int curPplNo = InputView.inputPpl();
        ppl.add(curPplNo);
    }

    public static void main(String[] args) {
        System.out.println("##상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        printSelectMovie(movieId,0);

        selecMovieTime(0);
        // TODO 구현 진행
    }


}


