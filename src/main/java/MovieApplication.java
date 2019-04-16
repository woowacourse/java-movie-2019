import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule; ////////////////////추가 가능?
import view.InputView;
import view.OutputView;
import utils.DateTimeUtils;

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
            getSelectMovie(no);
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

    private static boolean timeGap() {
        boolean output = true;
        if (curSchedule.size() >= 2) {
            output = DateTimeUtils.isOneHourWithinRange(curSchedule.get(0).getStartDateTime(), curSchedule.get(curSchedule.size() - 1).getStartDateTime());
        }
        return output;
    }

    private static boolean comparisonNo(int i) {
        if (curSchedule.get(i).getCapacity() < ppl.get(i)) {
            return false;
        }
        return true;
    }

    private static boolean acceptablePplCheck() {
        boolean cheak = true;
        int i = 0;
        while (cheak && i < curSchedule.size()) {
            cheak = comparisonNo(i);
            i++;
        }
        return cheak;
    }

    private static boolean pastMovie() {
        boolean cheak = true;
        int i = 0;
        while (cheak && i < curSchedule.size()) {
            cheak = DateTimeUtils.isProbabilityCheck(curSchedule.get(i).getStartDateTime());
            i++;
        }
        return cheak;
    }

    private static boolean payProbabilityCheck() {
        boolean cheak[] = {true,true,true};
        cheak[0] = timeGap();
        if (!cheak[0]) System.out.println("영화의 시간차이가 1시간 이내가 아닙니다.");
        cheak[1] = acceptablePplCheck();
        if (!cheak[1]) System.out.println("예매 가능 인원을 초과하였습니다.");
        cheak[2] = pastMovie();
        if (!cheak[2]) System.out.println("상영 시작 시간이 이미 지난 영화가 있습니다.");

        if(cheak[0] && cheak[1] && cheak[2]) return true;
        return false;
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
        int output = 0;
        total -= InputView.inputPoint();
        int method = InputView.inputPaymentMethod();
        if (method == 1) {
            output = (int) (total * 0.95);
        } else if (method == 2) {
            output = (int) (total * 0.98);
        }
        System.out.println("최종 결제한 금액은 " + output + "원입니다.");
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
    }

    private static void listInit(){
        curMovies.clear();
        curSchedule.clear();
        ppl.clear();
    }

    private static void booking() {
        selectMoveis();
        printCurrentState();
        if(payProbabilityCheck()){
            payment();
        }
        else{
            System.out.println("--------------------------------");
            System.out.println("예매를 처음부터 다시 시작합니다.");
            listInit();
            booking();
        }

    }

    public static void main(String[] args) {
        System.out.println("##상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        booking();
    }
}


