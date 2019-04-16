package service;

import domain.Movie;
import domain.MovieRepository;
import view.OutputView;

import java.util.List;

public class MovieReservation {
    public void run() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

    }

}

