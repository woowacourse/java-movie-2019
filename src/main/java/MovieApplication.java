import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule; ////////////////////추가 가능?
import view.InputView;
import view.OutputView;


import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    private static List<Movie> curMovies = new ArrayList<>();
    private static List<PlaySchedule> curSchedule = new ArrayList<>();
    private static List<Integer> ppl = new ArrayList<>();

    private static void getSelectMovie(int no) {
        int movieId = InputView.inputMovieId();
        Movie temp = MovieRepository.getSelectMovies(movieId);
        if (temp == null) {
            System.out.println("해당 영화가 없습니다.");
        } else {
            System.out.println(temp);
            curMovies.add(temp);
        }
    }

    private static void getMovieTime(int no) {
        int selectTime = InputView.inputTime();
        PlaySchedule tempSchedule = curMovies.get(no).getSchedule(selectTime);
        System.out.println(tempSchedule);
        curSchedule.add(tempSchedule);
    }

    private static void getPpl(int no) {
        int curPplNo = InputView.inputPpl();
        ppl.add(curPplNo);
    }

    private static void printCurrentState() {
        System.out.println("예약 내역");
        for (int i = 0; i < curMovies.size(); i++) {
            System.out.print(curMovies.get(i).toString(true));
            System.out.print(curSchedule.get(i).toString(true));
            System.out.println("예약 인원:" + ppl.get(i) + "명");
            System.out.println();
        }
    }

    private static boolean payProbabilityCheck() {


        return true;
    }

    private static double getTotalMoney() {
        double money = 0;
        for (int no = 0; no < curMovies.size(); no++) {
            money += curMovies.get(no).getPrice() * ppl.get(no);
        }
        return money;
    }

    private static void payment() {
        double total = getTotalMoney();
        total -= InputView.inputPoint();
        int method = InputView.inputPaymentMethod();
        if(method == 1){
            total = total*0.95;
        }else if(method == 2){
            total = total*0.98;
        }
        System.out.println("최종 결제한 금액은 " + total +"원입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    private static void selectMoveis() {
        boolean continueCheak = true;
        int no = -1;
        while (continueCheak) {
            no++;
            getSelectMovie(no);
            getMovieTime(no);
            getPpl(no);
            continueCheak = InputView.inputContinueCheak();
        }
        printCurrentState();
        payment();
    }

    public static void main(String[] args) {
        System.out.println("##상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        selectMoveis();


    }


}


