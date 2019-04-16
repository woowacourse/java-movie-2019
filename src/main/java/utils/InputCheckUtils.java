package utils;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class InputCheckUtils {
        public static void checkInputReservationMoive(int input) throws Exception{
                if(input <= 0)
                        throw new Exception("음수 또는 0 입력 오류");
                if(!checkValidMoiveId(input))
                        throw new Exception("상영 번호 입력 오류");
                return;
        }

        private static boolean checkValidMoiveId(int input){
                boolean valid = false;
                for(Movie movie : MovieRepository.getMovies()){
                        valid = movie.compareId(input) ? true : valid;
                }
                return valid;
        }

        public static void checkInputReservationSchedule(int movieId, int selectedSchedule) throws  Exception{
                boolean valid =false;
                if(selectedSchedule <= 0)
                        throw new Exception("음수 또는 0 입력 오류");
                for(Movie movie : MovieRepository.getMovies()){
                        valid = movie.hasSchedule(movieId,selectedSchedule) ? true : valid;
                }
                if(!valid){
                        throw new Exception("예약 시간표 입력 오류");
                }
                return;
        }

        public static void checkInputMoviePeople(int movieId, int schedule, int people) throws Exception {
                boolean valid =false;
                if(people <= 0)
                        throw new Exception("음수 또는 0 입력 오류");
                for(Movie movie : MovieRepository.getMovies()){
                        valid = movie.isValidPeople(movieId,schedule,people) ? true : valid;
                }
                if(!valid){
                        throw new Exception("예약 인원 수 입력 오류");
                }
                return;
        }
}
