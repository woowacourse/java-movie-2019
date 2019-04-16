package domain;

import view.InputView;
import view.OutputView;

public class Ticketing {
    public static ReserveMovie startTitcketing() {
        int movieId = InputView.inputMovieId();
        Movie currentMovie = MovieRepository.searchMovies(movieId, 0);
        OutputView.printMovie(currentMovie);
        int movieTimeTable = InputView.inputTimetable();
        while (currentMovie.getPlaySchedules().get(movieTimeTable).isOverStartTime()) {
            System.out.println("상영 시간이 지났습니다. 다시 선택 해 주세요.");
            movieTimeTable = InputView.inputTimetable();
        }
        int movieNumOfPerson = InputView.inputNumOfPerson();
        while (currentMovie.getPlaySchedules().get(movieTimeTable).isOverCapacity(movieNumOfPerson)) {
            System.out.println("예매 가능 인원을 초과합니다. 다시 선택 해 주세요.");
            movieNumOfPerson = InputView.inputNumOfPerson();
        }
        return new ReserveMovie(currentMovie, currentMovie.getPlaySchedules().get(movieTimeTable), movieNumOfPerson);
    }
}
