import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    private static final String INFO_MOVIE = "##상영 영화 목록";
    private static final String INFO_CHOIE= "##예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String INFO_NUM = "##예약할 인원을 입력하세요.";
    private static final String INFO_CONTINUE = "##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String INFO_BOOKING = "예약내역";
    private static final String INFO_PAY = "## 결제를 진행합니다.";
    private static final String INFO_POINT = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String INFO_CARD = "## 신용카드는 1번, 현금은 2번";
    private static final int BIRTHDAY = 1;
    private static final int MONEY = 5;
    private static final int FIVEFIT = 7;
    private static final int DUMBO = 8;

    private static int movieTime = 0;
    private static int movieNum = 0;
    private static int movieContinue = 0;
    private static Movie choiceMovie;
    private static List<Movie> movies = MovieRepository.getMovies();
    private static ArrayList<Movie> choiceMovies = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(INFO_MOVIE);
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        choiceMovie = choiceMovie(movies, movieId);
        System.out.println(choiceMovie);
        movieTime();
        movieNumber();
        movieContinue();
        checkBooking();
    }

    public static void checkBooking() {
        if(movieContinue == 1) {
            choiceMovies.add(choiceMovie);
            showBooking();
        }
        if(movieContinue == 2) {
            choiceMovies.add(choiceMovie);
            int movieId = InputView.inputMovieId();
            choiceMovie = choiceMovie(movies, movieId);
            System.out.println(choiceMovie);
            movieTime();
            movieNumber();
            movieContinue();
            checkBooking();
        }
    }

    public static void showBooking() {
        System.out.println(INFO_BOOKING);
        for(int i = 0 ; i < choiceMovies.size(); i++) {
            System.out.println(choiceMovies.get(i).choiceTime(movieTime));  //choice Time
            System.out.println("예약 인원 : " + movieNum + "명");
        }
    }

    public static void movieTime() {
        System.out.println(INFO_CHOIE);
        Scanner scan = new Scanner(System.in);
        movieTime = scan.nextInt();
    }

    public static void movieNumber() {
        System.out.println(INFO_NUM);
        Scanner scan = new Scanner(System.in);
        movieNum = scan.nextInt();
    }

    public static void movieContinue() {
        System.out.println(INFO_CONTINUE);
        Scanner scan = new Scanner(System.in);
        movieContinue = scan.nextInt();
    }

    public static Movie choiceMovie(List<Movie> movies, int movieId) {
        if(movieId == BIRTHDAY) {
            return movies.get(0);
        }
        if(movieId == MONEY) {
            return movies.get(1);
        }
        if(movieId == FIVEFIT) {
            return movies.get(2);
        }
        if(movieId == DUMBO) {
            return movies.get(3);
        }
        else
        System.out.println("입력한 값이 영화목록에 없습니다. 다시 입력해주세요.") ;
        System.exit(1);
        return movies.get(movieId);
    }
}
