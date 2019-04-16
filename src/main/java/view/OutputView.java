package view;

import domain.Movie;
import domain.SelectedMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printInputMovieSchedule(List<Movie> movies, int index) {
        System.out.println(movies.get(index));
    }

    public static void printImpossibleReasonSelectedMovieNotOnTheList() {
        System.out.println("상영 목록에 없는 영화를 선택하셨습니다. 예매가 불가능합니다. 다시 선택해주세요.\n");
    }

    public static void printImpossibleReasonSelectedMovieAlreadyStartTime() {
        System.out.println("상영 시작 시간이 이미 지난 영화를 선택하셨습니다. 예매가 불가능합니다. 다시 선택해주세요.\n");
    }

    public static void printImpossibleReasonWatchPeopleExceeding() {
        System.out.println("예매 가능 인원을 초과하였습니다. 예매가 불가능합니다. 다시 입력해주세요.\n");
    }

    public static void printSelectedMovies(List<SelectedMovie> selectedMovies) {
        System.out.println("예약 내역");
        for (SelectedMovie selectedMovie : selectedMovies) {
            System.out.println(selectedMovie);
        }
    }
}
