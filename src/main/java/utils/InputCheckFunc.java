package utils;

import domain.Movie;
import domain.PlaySchedule;
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
            throw new InputMovException("상영 목록의 번호를 입력해주세요.");
        }
        if(!checkMovieIdTimePeople(MovieFunc.getMovieSameId(inputId,movies))){
            throw new InputMovException("예매 가능한 시간이 없습니다.(시간 및 인원수)");
        }
    }

    private static boolean checkMovieIdTimePeople(Movie movie){
        for(PlaySchedule playSchedule : movie.getPlaySchedules()){
            if(DateTimeUtils.isNotPastMovieSch(playSchedule.getStartDateTime())){
                return playSchedule.isCapacityNotZero();
            }
        }
        return false;
    }

    /**
     * 3. 이전 영화보다 한시간 이내의(추후 추가 필요)
     * */
    public static void checkMovieSch(int inputSch, Movie movie){
        if(inputSch < 1 || inputSch > movie.getSchSize()){
            throw new InputMovException("시간표의 숫자만 입력해주세요.");
        }
        if(!DateTimeUtils.isNotPastMovieSch(movie.getSchStartTime(inputSch-1))){
            throw new InputMovException("지난 시간의 영화는 예매할 수 없습니다.");
        }
        if(!movie.isCapacityNotZero(inputSch-1)){
            throw new InputMovException("예약할 수 있는 인원이 없습니다.");
        }
    }

    public static void checkMovieCapa(int inputCapa, Movie movie, int sch){
        if(inputCapa <= 0){
            throw new InputMovException("0 이상의 숫자를 입력해주세요");
        }
        if(!movie.isInnerCapacity(sch-1,inputCapa)){
            throw new InputMovException("예약 가능 인원을 초과했습니다.");
        }
    }

    public static void checkLoopMovie(int inputLoop){
        if(inputLoop != 1 && inputLoop != 2){
            throw new InputMovException("1 혹은 2만 입력하세요");
        }
    }
}
