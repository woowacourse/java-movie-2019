/*
 * MovieApplication Class
 *
 * @version 1.4
 *
 * @date 2019-04-16
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        int movieId;

        printBoxOfficeMovie();
        movieReserveProcess();
        // TODO 구현 진행
    }

    public static void printBoxOfficeMovie() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    //구매 진행 프로세스
    public static void movieReserveProcess() {
        int movieID ;
        try {
            movieID = selectMovieByID();
            printSelectedMovieInfo(movieID);
            selectMovieTimeAtMovieID(movieID);

        } catch (IllegalArgumentException e) {
            OutputView.printRestartReservation(e);
            movieReserveProcess();
        }
    }

    //구매할 ID 선택
    public static int selectMovieByID() {
        int selectedMovieId = InputView.inputMovieId();

        if (!MovieRepository.isContainMovieId(selectedMovieId))
            throw new IllegalArgumentException("해당하는 영화의 ID 가 없습니다.");

        return selectedMovieId;
    }

    //선택한 영화에서 시간 선택
    public static int selectMovieTimeAtMovieID(int movieId){
        int selectedMovieTime = InputView.inputTime();
        if( !MovieRepository.isContainMovieTimeAtMovieId(movieId, selectedMovieTime) )
            throw new IllegalArgumentException("해당 시간은 존재하지 않습니다.");

        return selectedMovieTime;
    }

    //선택된 영화 번호 출력
    public static void printSelectedMovieInfo(int movieId) {
        Movie selectedMovie =
                MovieRepository.getMovieByID(movieId);
        OutputView.printSelectedMovieInfo(selectedMovie);
    }
}
