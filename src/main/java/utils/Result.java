package utils;

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Movie> movies;
    private List<Integer> movieId = new ArrayList<>();
    private List<Integer> movieTime = new ArrayList<>();
    private List<Integer> moviePeople = new ArrayList<>();

    public Result(List<Movie> movies, int movieNumber) {
        this.movieId.add(movieNumber);
        this.movies = movies;
    }

    public void startMovieResult() {
        movieTime.add(InputView.inputMovieTime());
        moviePeople.add(InputView.inputMoviePeople());
        setMovieResult(InputView.inputMovieExit());
    }

    private void setMovieResult(int num) {
        if (num == 2) {
            startMovieSellect();
        }
        if (num == 1) {
            startMoviePay(); // TODO 결제 진행하기
        }
    }

    private void startMoviePay() { //TODO 결제 진행
        int sum = 0;
        for (int i = 0; i < movieId.size(); i++) {
            movies.get(movieId.get(i)).toStringInfo(movieTime.get(i), moviePeople.get(i));
            sum += movies.get(movieId.get(i)).getTotalPrice(moviePeople.get(i));
        }
        int point = InputView.inputPoint();
        double pay = InputView.inputPay();
        OutputView.printResult(sum, point, pay);
    }

    private void startMovieSellect() {
        int movieNumber = Data.getMovieId(InputView.inputMovieId());
        movieId.add(movieNumber);
        OutputView.printMovieInfo(movies.get(movieNumber).toString());
        movieTime.add(InputView.inputMovieTime());
        moviePeople.add(InputView.inputMoviePeople());
        setMovieResult(InputView.inputMovieExit());
    }
}
