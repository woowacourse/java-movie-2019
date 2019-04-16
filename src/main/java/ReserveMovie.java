import domain.Movie;
import domain.SelectedMovie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReserveMovie {
    private static List<SelectedMovie> selectedMovies = new ArrayList<>();
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

    public static int assertMovieId(List<Movie> movies, int movieId) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == movieId) {
                return i;
            }
        }
        return -1;
    }

    public static boolean assertMovieSchedule(Movie movie, int movieSchedule) {
        if (movie.getPlaySchedules().get(movieSchedule - 1).getStartDateTime().isAfter(LocalDateTime.now())) {
            return true;
        }
        return false;
    }
} 
