package utils;

import domain.Movie;
import exception.InputMovException;

import java.util.ArrayList;
import java.util.List;

public class InputCheckFunc {
    public static void checkMovieId(int inputId, List<Movie> movies){
        List<Integer> moviesIdList = new ArrayList<>();
        for(Movie movie : movies){
            moviesIdList.add(movie.getId());
        }
        if(!moviesIdList.contains(inputId)){
            throw new InputMovException();
        }
    }

    /**
     * 1. 영화 스케줄 길이
     * 2. 지금 시간보다 늦은
     * 3. 이전 영화보다 한시간 이내의(추후 추가 필요)
     * */
    public static void checkMovieSch(int inputSch, Movie movie){
        if(inputSch < 1 || inputSch > movie.getSchSize()){
            throw new InputMovException("시간표의 숫자만 입력해주세요.");
        }
        if(!DateTimeUtils.isPastMovieSch(movie.getSchStartTime(inputSch-1))){
            throw new InputMovException("지난 시간의 영화는 예매할 수 없습니다.");
        }
    }
}
