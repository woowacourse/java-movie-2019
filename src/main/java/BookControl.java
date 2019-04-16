import domain.BookedMovie;
import domain.Movie;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BookControl {
    private List<Movie> movies; // MovieRepository로부터 가져온 영화 목록 저장 변수
    private List<BookedMovie> bookedMovies = new ArrayList<>(); // 예약된 영화를 저장할 변수

    public BookControl(List<Movie> movies) {
        this.movies = movies;
    }

    // #1 영화를 예약하는 함수
    public void bookMovie() {
        int movieId = chooseMovie();
        int time_index = chooseTime(movieId);
        int people = howManyPeople(movieId, time_index);

        addBookedMovies(movieId, time_index, people);
    }

    // #1-1 예약할 영화를 입력받는 함수
    private int chooseMovie() {
        OutputView.printMovies(movies);
        int movieId = -1;
        do {
            movieId = InputView.inputMovieId();
        } while (checkMovieId(movieId));
        OutputView.printMoviesByID(movies, movieId);
        return movieId;
    }

    // #1-1-1 상영목록의 영화인지 체크하는 함수
    private boolean checkMovieId(int id) {
        for (Movie movie : movies) {
            if (id == movie.getID())
                return true;
        }
        System.out.println("상영목록엔 없는 영화입니다.");
        return false;
    }

    // #1-2 예약할 영화의 시간을 입력받는 함수
    private int chooseTime(int id) {
        int index = -1;
        do {
            index = InputView.inputMovieTime() - 1;
        } while (checkIndex(index, id));
        return index;
    }

    // #1-2-1 예약할 영화의 시간이 정확한지 체크하는 함수
    private boolean checkIndex(int index, int id) {
        Movie temp = getMovieByID(id);
        if (temp.getPlaySchedules().size() > index)
            return true;
        System.out.println("상영시간을 잘못 입력하였습니다.");
        return false;
    }

    // #1-2-2 해당 ID의 영화를 불러오는 함수
    private Movie getMovieByID(int id) {
        for (Movie movie : movies) {
            if (id == movie.getID())
                return movie;
        }
        return null;
    }

    // #1-3 예약 인원을 입력받는 함수
    private int howManyPeople(int id, int index) {
        int num = -1;
        PlaySchedule temp = getMovieByID(id).getPlaySchedules().get(index);
        do {
            num = InputView.inputPeopleNum();
        } while (checkPeople(num, temp));
        return num;
    }

    // #1-3-1 입력받은 인원이 가능한지 판별하는 함수
    private boolean checkPeople(int num, PlaySchedule playSchedule) {
        if (num <= playSchedule.getCapacity())
            return true;
        System.out.println("예약 가능인원을 초과하였습니다.");
        return false;
    }

    // #1-4 예약한 영화를 저장할 함수
    private void addBookedMovies(int id, int time, int num) {
        Movie target = getMovieByID(id);
        bookedMovies.add(new BookedMovie(id, target.getName(), 
                    target.getPrice(), target.getPlaySchedules().get(time).getStartDateTime(), num));
        PlaySchedule temp = new PlaySchedule(target.getPlaySchedules().get(time).getStartDateTime(), target.getPlaySchedules().get(time).getCapacity() - num);
        target.getPlaySchedules().remove(time);
        target.getPlaySchedules().add(time, temp);

    }

    // #1-5 예매를 더 할지 결제로 넘어갈지 판단하는 함수
    public boolean checkMoreBook() {
        int input_num = -1;
        do {
            input_num = InputView.inputMoreBook();
        } while(!(isCorrectInput(input_num)));
        if (input_num == 1) return true;
        System.out.println("## 결제를 진행합니다.");
        return false;
    }

    // #1-5-1 유저의 입력이 정확한지 판단하는 함수
    private boolean isCorrectInput(int input) {
        if (input == 1 || input == 2) return true;
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    // #2 예약된 목록을 출력하는 함수
    public void printBookedMovies() {
        OutputView.printBookedMovies(bookedMovies);
    }

    // #3 결제를 진행할 함수
    public void purchaseMovieTickets() {

    }
}