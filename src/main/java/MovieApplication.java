import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        Movie choiceMovie =  OutputView.printChoiceMovies(movies, movieId);
        int choiceTime = InputView.inputChoiceTime();
        int reservedPerson = InputView.inputReservedPerson();

        reservedTimeSchedule(choiceMovie, choiceTime, reservedPerson);

    }

    private static void reservedTimeSchedule(Movie choiceMovie, int choiceTime, int reservedPerson){
        System.out.println("영화 선택 : " + choiceMovie.choiceMovie()
                +", 얘약 가능인원: "+choiceMovie.getPlaySchedules().get(choiceTime-1).getCapacity()
            + ", 시작시간: " + choiceMovie.getPlaySchedules().get(choiceTime-1).getStartDateTime());
    }
}
