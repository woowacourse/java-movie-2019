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
        while (isReplay()) ;
    }

    private boolean isReplay() {
        while (true) {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);

            Reservation reservation = getReservationMovie(movies);
            System.out.println(reservation.toString());
        }
    }

    private boolean checkCapacity(int people, int movieId, int movieSchedule) {
        if (people > MovieRepository.selectCapacity(movieId, movieSchedule)) {
            System.out.println(MovieRepository.selectCapacity(movieId, movieSchedule));
            System.err.println("예약가능 인원이 초과 하였습니다.");
            return true;
        }

        return false;
    }

    private Reservation getReservationMovie(List<Movie> movies) {
        int movieId = selectMovieId(movies);
        Movie movie = getMovie(movies, movieId);
        int movieSchedule = InputView.inputMovieTime();
        int personNumber = selectPeopleNumber(movieId, movieSchedule);
        PlaySchedule playSchedule = selectMovieSchedule(movieId, movieSchedule);

        Reservation reservation = new Reservation(movie, personNumber, playSchedule);
        return reservation;
    }

    private PlaySchedule selectMovieSchedule(int movieId, int movieSchedule) {
        PlaySchedule schedule = MovieRepository.selectSchedule(movieId, movieSchedule);

        return schedule;
    }

    private Movie getMovie(List<Movie> movies, int movieId) {
        Movie selectMovie = movies.get(movieId);

        Movie movie = new Movie(movieId, selectMovie.getName(), selectMovie.getPrice());
        return movie;
    }

    private int selectPeopleNumber(int movieId, int movieSchedule) {
        int peopleNumber = InputView.inputPeopleNumber();

        if (checkCapacity(peopleNumber, movieId, movieSchedule)) {
            return selectPeopleNumber(movieId, movieSchedule);
        }

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

