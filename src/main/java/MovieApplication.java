import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie selectedMovie = getPlaySchedulesOfSelectedMovie();        // 영화 선택

        //TODO 상영시간이 지났는지 여부 확인
        System.out.println(selectMovieSchedule(selectedMovie));
    }

    private static Movie getPlaySchedulesOfSelectedMovie() {
        try {
            int movieId = InputView.inputMovieId();
            return OutputView.getMoviePlaySchedule(movieId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlaySchedulesOfSelectedMovie();
        }
    }

    private static List<PlaySchedule> setReservedAllMovieToList(PlaySchedule playSchedule, int theNumberOfPerson) {
        List<PlaySchedule> reservedMovies = new ArrayList<>();
        for (int i = 0; i < theNumberOfPerson; i++) {
            reservedMovies.add(playSchedule);
        }
        return reservedMovies;
    }

    private static PlaySchedule getPlayScheduleByNumber(Movie selectedMovie) {
        try {
            int scheduleId = InputView.inputMovieScheduleId();             // 시간표 선택
            return selectedMovie.getPlaySchedules().get(scheduleId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayScheduleByNumber(selectedMovie);
        }
    }

    /* 영화 선택이후 결제 전까지의 영화 선택 과정을 담은 메소드 */
    private static List<PlaySchedule> selectMovieSchedule(Movie selectedMovie){
        try{
            PlaySchedule selectedPlaySchedule = getPlayScheduleByNumber(selectedMovie);
            int theNumberOfPerson = InputView.inputTheNumberOfPerson();
            selectedPlaySchedule.checkPersonOverCapacity(theNumberOfPerson);
            return setReservedAllMovieToList(selectedPlaySchedule, theNumberOfPerson);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return selectMovieSchedule(selectedMovie);
        }
    }
}
