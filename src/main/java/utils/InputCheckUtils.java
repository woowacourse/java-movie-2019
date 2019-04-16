package utils;

import domain.Movie;

import java.util.List;

public class InputCheckUtils {
        public static void checkInputReservationMoive(int input, List<Movie> movies) throws Exception{
                if(input <= 0)
                        throw new Exception("음수 또는 0 입력 오류");
                if(!checkValidMoiveId(input,movies))
                        throw new Exception("상영번호 입력 오류");
                return;
        }

        private static boolean checkValidMoiveId(int input, List<Movie> movies){
                boolean valid = false;
                for(Movie movie : movies){
                        valid = movie.compareId(input);
                }
                return valid;
        }
}
