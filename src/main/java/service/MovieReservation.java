package service;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieReservation {
    public void run() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Reservation reservation = getReservationMovie(movies);
        System.out.println(reservation.toString());
    }

    private Reservation getReservationMovie(List<Movie> movies) {
        int movieId = selectMovieId(movies);
        Movie movie = getMovie(movies, movieId);
        int personNumber = selectPeopleNumber();
        PlaySchedule playSchedule = selectMovieSchedule(movieId);

        Reservation reservation = new Reservation(movie, personNumber, playSchedule);
        return reservation;
    }

    private PlaySchedule selectMovieSchedule(int movieId) {
        int movieSchedule = InputView.inputMovieTime();
        PlaySchedule schedule = MovieRepository.selectSchedule(movieId, movieSchedule);

        return schedule;
    }

    private Movie getMovie(List<Movie> movies, int movieId) {
        Movie movie = new Movie(movieId, movies.get(movieId).getName(), movies.get(movieId).getPrice());
        return movie;
    }

    private int selectPeopleNumber() {
        int peopleNumber = InputView.inputPeopleNumber();

        return peopleNumber;
    }

    private List<Integer> makeMoviesIdList(List<Movie> movies) {
        List<Integer> movieIdList = new ArrayList<>();

        for (Movie movie : movies) {
            movieIdList.add(movie.getId());
        }

        return movieIdList;
    }

    private boolean notInSchedule(List<Movie> movies, int movieId) {
        List<Integer> movieIdList = makeMoviesIdList(movies);

        if (!movieIdList.contains(movieId)) {
            System.err.println("상영목록에 없는 영화입니다.");
            return true;
        }

        return false;
    }

    private int selectMovieId(List<Movie> movies) {
        int movieId = InputView.inputMovieId();

        if (notInSchedule(movies, movieId)) {
            return selectMovieId(movies);
        }

        return movieId;
    }

}

