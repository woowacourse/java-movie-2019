import domain.Movie;

import java.util.List;

public class BookControl {
    private List<Movie> movies; // MovieRepository로부터 가져온 영화 목록 저장 변수

    public BookControl(List<Movie> movies) {
        this.movies = movies;
    }

    // #1 영화를 예약하는 함수
    public void bookMovie() {

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