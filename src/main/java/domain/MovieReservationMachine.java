package domain;

import view.OutputView;

import java.util.List;


/**
 * 영화 예매기 역할을 하는 클래스
 */
public class MovieReservationMachine {

    /**
     * 현재 상영중인 영화들의 목록을 출력하는 메소드
     */
    public static void showAvailableMovies() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    /**
     * 특정 영화의 스케쥴을 출력하는 메소드
     */
    public static void showSchedulesOfMovieWithId(int id) {
        OutputView.printMovie(MovieRepository.getMovieWithId(id));
    }

}
