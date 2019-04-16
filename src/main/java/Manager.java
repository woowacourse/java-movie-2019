import domain.Movie;
import domain.MovieRepository;
import domain.UserMovie;
import utils.MyUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Manager {
    private InputError inputError;
    private MyUtil myUtil;
    private List<Movie> movies;
    private User user;
    private int movieId;
    private int timeId;
    private int peopleCount;
    private int isPay;
    private int totalAmount;

    Manager(){
        inputError = new InputError();
        myUtil = new MyUtil();
        user = new User();
        totalAmount = 0;
    }

    public void startReserve(){
        // 유저무비 변수 초기화
        this.movies = MovieRepository.getMovies();
        while(!reserveProcess());
        //printResult
        System.out.println("## 결제를 진행합니다.");
        InputView.inputPoint();
        InputView.inputHowPay();
        printResult();
    }

    public void printResult(){
        System.out.print("최종 결제한 금액은 ");
        System.out.print(totalAmount);
        System.out.println("원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    public boolean reserveProcess(){
        System.out.println("## 상영 영화 목록");
        OutputView.printMovies(movies);
        while(!firstQuery());
        OutputView.printIdMovie(movies, movieId);
        while(!secondQuery());
        while(!thirdQuery());
        while(!fourthQuery());
        // userlist에 집어넣어야 한다.
        user.getUserList().add(new UserMovie(movieId, timeId, peopleCount));
        if(isPay == 2) return false;
        printReserveAll();
        return true;
    }

    public void printReserveAll(){
        System.out.println("예약 내역");
        List<UserMovie> userList = User.getUserList();
        for(int i=0; i<userList.size(); i++){
            UserMovie userMovie = userList.get(i);
            Movie movie = getMovie(userMovie.getMovieId());
            System.out.print(movie.getId());
            System.out.print(" - ");
            System.out.print(movie.getName());
            System.out.print(", ");
            System.out.println(movie.getPrice());
            System.out.println(movie.getStartTime(userMovie.getTimeId()));
            System.out.print("예약 인원: ");
            System.out.println(userMovie.getPeopleCount());
            totalAmount += movie.getPrice() * userMovie.getPeopleCount();
            System.out.println();
        }
    }

    public Movie getMovie(int movieId){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getId() == movieId){
                return movies.get(i);
            }
        }
        return null;
    }

    public boolean fourthQuery(){
        isPay = InputView.inputIsEndOrNot();
        if(!inputError.checkOneTwo(isPay)){
            return false;
        }
        return true;
    }

    public boolean thirdQuery(){
        peopleCount = InputView.inputPeopleCount();
        if(!inputError.CheckMinusError(movieId) || !inputError.checkPeopleCount(movies, movieId, timeId, peopleCount)){
            return false;
        }
        return true;
    }

    public boolean firstQuery(){
        movieId = InputView.inputMovieId();
        if(!inputError.CheckMinusError(movieId) || !inputError.checkContainId(movies, movieId)){
            return false;
        }
        return true;
    }

    public boolean secondQuery(){
        timeId = InputView.inputTimetable();
        if(!inputError.CheckMinusError(timeId) || !inputError.checkContainTimeIndex(movies, movieId, timeId)){
            return false;
        }
        return true;
    }
}
