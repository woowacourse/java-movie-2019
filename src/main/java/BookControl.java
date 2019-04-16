import domain.Movie;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BookControl {
    private List<Movie> movies; // MovieRepository로부터 가져온 영화 목록 저장 변수

    public BookControl(List<Movie> movies) {
        this.movies = movies;
    }

    // #1 영화를 예약하는 함수
    public void bookMovie() {
        int movieId = chooseMovie();
        int time_index = chooseTime(movieId);
    }

    // #1-1 예약할 영화를 입력받는 함수
    private int chooseMovie() {
        OutputView.printMovies(movies);
        int movieId = -1;
        do {
            movieId = InputView.inputMovieId();
        } while(checkMovieId(movieId));
        return movieId;
    }

    // #1-1-1 상영목록의 영화인지 체크하는 함수
    private boolean checkMovieId(int id) {
        for (Movie movie : movies) {
            if (id == movie.getID()) return true;
        }
        System.out.println("상영목록엔 없는 영화입니다.");
        return false;
    }

    // #1-2 예약할 영화의 시간을 입력받는 함수
    private int chooseTime(int id) {
        int index = -1;
        do {
            index = InputView.inputMovieTime() - 1;
        } while(checkIndex(index, id));
        return index;
    }

    // #1-2-1 예약할 영화의 시간이 정확한지 체크하는 함수
    private boolean checkIndex(int index, int id) {
        Movie temp = getMovieByID(id);
        if (temp.getPlaySchedules().size() > index) return true;
        System.out.println("상영시간을 잘못 입력하였습니다.");
        return false;
    }

    // #1-2-2 해당 ID의 영화를 불러오는 함수
    private Movie getMovieByID(int id) {
        for (Movie movie : movies) {
            if (id == movie.getID()) return movie;
        }
        return null;
    }

    // 예매를 더 할지 결제로 넘어갈지 판단하는 함수
    public boolean checkMoreBook() {
        return false;
    }

    // #2 예약된 목록을 출력하는 함수
    public void printBookedMovies() {

    }

    // #3 결제를 진행할 함수
    public void purchaseMovieTickets() {

    }
}