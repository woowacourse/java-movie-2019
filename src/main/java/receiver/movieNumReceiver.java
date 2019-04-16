package receiver;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import error.Validator;
import error.exceptions.NotIntegerException;
import domain.Movie;
import error.exceptions.NotValidException;
import error.exceptions.NotInRangeException;

import java.util.List;
import java.util.Scanner;

public class movieNumReceiver {

    private static final String REQUEST_COMMENT = "##예약할 영화를 선택하세요";
    //재귀 함수를 이용한 구현
    public static int getMovieNumFromUser(Scanner sc) {
        System.out.println(REQUEST_COMMENT);
        try {
            String inputFromUser = sc.nextLine();
            checkValid(inputFromUser);
            return Integer.parseInt(inputFromUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getMovieNumFromUser(sc);
        }
    }

    private static void checkValid(String inputFromUser) throws Exception {
        List<Movie> movies = MovieRepository.getMovies();
        if (!Validator.isInteger(inputFromUser)) {    // 정수 변환 가능한지
            throw new NotIntegerException();
        }
        int movieNum = Integer.parseInt(inputFromUser);
        if (1 > movieNum || movieNum > 9) {    // 적은 금액인지
            throw new NotInRangeException();
        }
        for (Movie movie : movies) {
            int mid = movie.getId();
            if (mid == movieNum) {
                return;
            }

        }
        throw new NotInRangeException();
    }
}