package utils;

import domain.Movie;
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
        int timeSize = movies.get(movieId.get(0)).getTimeSize();
        movieTime.add(InputView.inputMovieTime(timeSize));
        int people = InputView.inputMoviePeople();
        moviePeople.add(movies.get(movieId.get(0)).setPeople(movieTime.get(0), people));
        setMovieResult(InputView.inputMovieExit());
    }

    private void setMovieResult(int num) {
        if (num == 2) {
            startMovieSellect();
        }
        if (num == 1) {
            startMoviePay();
        }
    }

    private void startMoviePay() {
        int sum = 0;
        for (int i = 0; i < movieId.size(); i++) {
            int people = moviePeople.get(movieId.get(i));
            movies.get(movieId.get(i)).toStringInfo(movieTime.get(i), people);
            sum += movies.get(movieId.get(i)).getTotalPrice(people);
        }
        int point = InputView.inputPoint();
        double pay = InputView.inputPay();
        OutputView.printResult(sum, point, pay);
    }

    private void startMovieSellect() {
        int movieNumber = Data.getMovieId(InputView.inputMovieId());
        int timeSize = movies.get(movieNumber).getTimeSize();

        movieId.add(movieNumber);
        OutputView.printMovieInfo(movies.get(movieNumber).toString());
        int time = InputView.inputMovieTime(timeSize);
        movieTime.add(time);
        int people = InputView.inputMoviePeople();
        movies.get(movieNumber).setPeople(time, people);
        moviePeople.add(people);
        setMovieResult(InputView.inputMovieExit());
    }
}
