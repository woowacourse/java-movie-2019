package domain;

import java.util.List;

/**
 * 예약자가 행동을 했을때 영화 객체에 접근하여
 * 관리하는 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
public class MovieService {
    public static Movie findMovieForId(List<Movie> movies, int movieId){
        for(Movie movie : movies){
            if(movie.isMatchedMovieId(movieId)){
                return movie;
            }
        }
        return null;
    }

    public static void updateMoviePlayScheduleCapacity(Movie selectedMovie,
                                                       int selectedMoviePlayTime, int reservationNum){
        selectedMovie.updateMoviePlaySchedule(selectedMoviePlayTime, reservationNum);
    }
}
