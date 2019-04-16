import domain.Movie;
import domain.SelectedMovie;

import java.util.ArrayList;
import java.util.List;

public class ReserveMovie {
    private static List<SelectedMovie> selectedMovies;
    private Movie selectMovie;
    private int selectMovieId;
    private int selectSchedule;
    private int selectPeople;

    public ReserveMovie(Movie selectMovie, int selectMovieId, int selectSchedule, int selectPeople){
        this.selectMovie = selectMovie;
        this.selectMovieId = selectMovieId;
        this.selectSchedule = selectSchedule;
        this.selectPeople = selectPeople;
    }

    public void possibleReserveMovie(Movie selectMovie, int selectMovieId, int selectSchedule, int selectPeople) {

    }

    public static boolean assertMovieId(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                return true;
            }
        }
        return false;
    }
} 
