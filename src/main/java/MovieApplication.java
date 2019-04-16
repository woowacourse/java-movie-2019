import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
    private static ArrayList<Integer> movieNum = new ArrayList<>();
    private static int movieContinue = 0;
    private static Movie choiceMovie;
    private static List<Movie> movies = MovieRepository.getMovies();
    private static ArrayList<Movie> choiceMovies = new ArrayList<>();
    private static int moviePoint = 0;
    private static int moviePayMethod = 0;
    private static int movieTotalPay = 0;
    private static ArrayList<LocalDateTime> dateTimes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(INFO_MOVIE);
        OutputView.printMovies(movies);
        continueBooking();
//        isOnehourTime();
        checkOnehourTime();
        startPay();
        printPay();
    }

    public static double discountPay(int totalMoney) {
        double money = totalMoney;

        if(moviePayMethod == 1) {
            money = money * 0.05;
        }
        if(moviePayMethod == 2) {
            money = money * 0.02;
        }
        return money;
    }

    public static void printPay() {
        int pointMoney = 0;
        double totalMoney = 0;

        for(int i = 0 ; i < choiceMovies.size(); i++) {
            movieTotalPay += (choiceMovies.get(i).getPrice() * movieNum.get(i));
        }
        pointMoney = movieTotalPay - moviePoint;
        totalMoney = pointMoney - discountPay(movieTotalPay);

        System.out.println("최종 결제 금액 :" + (int)totalMoney);
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요!");
    }

    public static void startPay() {
        System.out.println(INFO_PAY);
        System.out.println(INFO_POINT);
        Scanner scan = new Scanner(System.in);
        moviePoint = scan.nextInt();
        System.out.println(INFO_CARD);
        moviePayMethod = scan.nextInt();
    }

    public static void impossibleBooking() {
        for (int i = 0 ; i < movieNum.size(); i++) {
           if(choiceMovie.getCapacity(movieTime) < movieNum.get(i)) {
               System.out.println("예약 인원이 최대수용인원보다 많습니다.");
               continueBooking();
           }
        }
    }

    public static void checkOnehourTime() {
        boolean isOnehour;
        Collections.sort(dateTimes);    //오름차순 정렬
        LocalDateTime localMin = dateTimes.get(0);
        LocalDateTime localMax = dateTimes.get(dateTimes.size() - 1);
        System.out.println("localMin 의 값 : " + dateTimes.get(0));
        System.out.println("localMax 의 값 : " + dateTimes.get(dateTimes.size()-1));
        isOnehour = DateTimeUtils.isOneHourWithinRange(localMin, localMax);
        System.out.println("1시간 이상 차이가 나는가? " + isOnehour);
//        for(int i = 0; i< dateTimes.size(); i++) {
//            System.out.println("DateTime : " + dateTimes.get(i));
//        }
    }

    public static void isOnehourTime() {
        List<PlaySchedule> playSchedules;
        playSchedules = choiceMovie.getPlaySchedules();
        dateTimes.add(playSchedules.get(movieTime -1).getStartDateTime());
        System.out.println("IsOnehourTIme DateTime : + " +dateTimes.get(0));
    }

    public static void continueBooking() {
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
            impossibleBooking();
            isOnehourTime();
            showBooking();
        }
        if(movieContinue == 2) {
            choiceMovies.add(choiceMovie);
            impossibleBooking();
            isOnehourTime();
            continueBooking();
        }
    }

    public static void showBooking() {
        System.out.println(INFO_BOOKING);
        for(int i = 0 ; i < choiceMovies.size(); i++) {
            System.out.println(choiceMovies.get(i).choiceTime(movieTime));  //choice Time
        }
        for(int i = 0; i< movieNum.size(); i++) {
            System.out.println("예약 인원 : " + movieNum.get(i) + "명");
        }
    }

    public static void movieTime() {
        System.out.println(INFO_CHOIE);
        Scanner scan = new Scanner(System.in);
        movieTime = scan.nextInt();
    }

    public static void movieNumber() {
        int num = 0;
        System.out.println(INFO_NUM);
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        movieNum.add(num);
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
        continueBooking();
        return movies.get(movieId);
    }
}
